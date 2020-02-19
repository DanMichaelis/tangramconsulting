package com.dtcc.workflowmetrics.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dtcc.workflowmetrics.dao.MetricsItemsCustomFieldDao;
import com.dtcc.workflowmetrics.dao.MetricsItemsDao;
import com.dtcc.workflowmetrics.dao.MetricsItemsStatusDurationDao;
import com.dtcc.workflowmetrics.dao.MetricsItemsStatusTransitionDao;
import com.dtcc.workflowmetrics.dao.MetricsItemsTStatusDurationDao;
import com.dtcc.workflowmetrics.dao.MetricsItemsTStatusTransitionDao;
import com.dtcc.workflowmetrics.dao.StatusDao;
import com.dtcc.workflowmetrics.dao.StatusTValueDao;
import com.dtcc.workflowmetrics.entity.MetricsItems;
import com.dtcc.workflowmetrics.entity.MetricsItemsCustomField;
import com.dtcc.workflowmetrics.entity.MetricsItemsCustomFieldId;
import com.dtcc.workflowmetrics.entity.MetricsItemsId;
import com.dtcc.workflowmetrics.entity.MetricsItemsStatusDuration;
import com.dtcc.workflowmetrics.entity.MetricsItemsStatusTransition;
import com.dtcc.workflowmetrics.entity.MetricsItemsStatusTransitionId;
import com.dtcc.workflowmetrics.entity.Status;
import com.dtcc.workflowmetrics.entity.StatusId;

@Service
public class MetricsItemsDaoService {

	@Autowired
	MetricsItemsDao metricsItemsDao;

	@Autowired
	MetricsItemsCustomFieldDao metricsItemsCustomFieldDao;

	@Autowired
	MetricsItemsStatusDurationDao metricsItemsStatusDurationDao;

	@Autowired
	MetricsItemsStatusTransitionDao metricsItemsStatusTransitionDao;

	@Autowired
	MetricsItemsTStatusDurationDao metricsItemsTStatusDurationDao;

	@Autowired
	MetricsItemsTStatusTransitionDao metricsItemsTStatusTransitionDao;

	@Autowired
	StatusDao statusDao;

	@Autowired
	StatusTValueDao statusTValueDao;

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public MetricsItems save(MetricsItems webhookItem) {

		MetricsItems itemDetail = new MetricsItems();

		// check if data already exists in Metrics Items table

		MetricsItemsId mid = new MetricsItemsId(webhookItem.getItemKey(), webhookItem.getSourceSystemId());

		Optional<MetricsItems> storedData = metricsItemsDao.findById(mid);

		Long createDt = System.currentTimeMillis();
		
		if (webhookItem.getItemCreateDate() != null) {
			createDt = webhookItem.getItemCreateDate();
		}

		// if data is not present, add data, else update data
		if (storedData != null && storedData.isPresent()) {
			itemDetail = storedData.get();
		} else {
			itemDetail.setItemId(UUID.randomUUID().toString());
			itemDetail.setSourceSystemId(webhookItem.getSourceSystemId());
			itemDetail.setItemKey(webhookItem.getItemKey());
			itemDetail.setItemCreateDate(createDt);
			itemDetail.setItemCreator(webhookItem.getItemCreator());

		}

		itemDetail.setProjectId(webhookItem.getProjectId());
		itemDetail.setItemSummary(webhookItem.getItemSummary());
		itemDetail.setItemDescription(webhookItem.getItemDescription());
		itemDetail.setLastUpdateDate(webhookItem.getLastUpdateDate());
		itemDetail.setLastUpdateUser(webhookItem.getLastUpdateUser());

		MetricsItems storedItemDetail = metricsItemsDao.save(itemDetail);

		String itemId = storedItemDetail.getItemId();
		// MetricsItemsCustomField

		for (MetricsItemsCustomField cField : webhookItem.getMetricsItemsCustomField()) {
			MetricsItemsCustomField custFld = new MetricsItemsCustomField();

			MetricsItemsCustomFieldId custFldId = new MetricsItemsCustomFieldId(itemId, cField.getFieldName());

			Optional<MetricsItemsCustomField> storedCustomField = metricsItemsCustomFieldDao.findById(custFldId);

			// if data is not present, add data, else update data
			if (storedCustomField != null && storedCustomField.isPresent()) {
				custFld = storedCustomField.get();
			} else {
				custFld.setItemId(itemId);
				custFld.setCreateDate(createDt);
				custFld.setFieldName(cField.getFieldName());
				custFld.setFieldDatatype("CustomField");
				custFld.setSourceSystemId(storedItemDetail.getSourceSystemId());
			}
			custFld.setFieldValue(cField.getFieldValue());

			MetricsItemsCustomField storedCustField = metricsItemsCustomFieldDao.save(custFld);

			storedItemDetail.addCustomField(storedCustField);
		}

		// MetricsItemsStatusTransition table population
		// check if data is present in table

		String fromStatus = null;
		String toStatus = null;
		Long transitionTime = null;

		for (MetricsItemsStatusTransition statusField : webhookItem.getMetricsItemsStatusTransition()) {
			MetricsItemsStatusTransition statusFld = new MetricsItemsStatusTransition();

			MetricsItemsStatusTransitionId statusTransitionId = new MetricsItemsStatusTransitionId(itemId,
					statusField.getTransitionDate());

			Optional<MetricsItemsStatusTransition> storedStatusTransitionField = metricsItemsStatusTransitionDao
					.findById(statusTransitionId);

			// if data is not present, add data, else update data
			if (storedStatusTransitionField != null && storedStatusTransitionField.isPresent()) {
				statusFld = storedStatusTransitionField.get();
			} else {
				statusFld.setItemId(itemId);
				statusFld.setSourceSystemId(storedItemDetail.getSourceSystemId());
				statusFld.setProjectId(storedItemDetail.getProjectId());
				statusFld.setFromStatus(statusField.getFromStatus());
				statusFld.setToStatus(statusField.getToStatus());
				statusFld.setTransitionDate(statusField.getTransitionDate());
			}
			MetricsItemsStatusTransition storedStatusTrans = metricsItemsStatusTransitionDao.save(statusFld);

			fromStatus = storedStatusTrans.getFromStatus();
			toStatus = storedStatusTrans.getToStatus();
			transitionTime = storedStatusTrans.getTransitionDate();

			storedItemDetail.addStatusTransition(storedStatusTrans);
		}

		// check is from and to status are present in status table, if not, add data

		if (fromStatus.length() > 0) {
			StatusId siFromData = new StatusId(storedItemDetail.getSourceSystemId(), fromStatus);
			Optional<Status> fromStatusData = statusDao.findById(siFromData);
			if (fromStatusData == null || !fromStatusData.isPresent()) {

				Status st = new Status();
				st.setName(fromStatus);
				st.setLastUpdateDate(createDt);
				st.setSourceSystemId(storedItemDetail.getSourceSystemId());
				st.setDescription("Added missing status");
				st.setStatusId(UUID.randomUUID().toString());

				statusDao.save(st);
			}
		}

		if (toStatus.length() > 0) {
			StatusId siToData = new StatusId(storedItemDetail.getSourceSystemId(), toStatus);
			Optional<Status> toStatusData = statusDao.findById(siToData);
			if (toStatusData == null || !toStatusData.isPresent()) {

				Status st = new Status();
				st.setName(toStatus);
				st.setLastUpdateDate(createDt);
				st.setSourceSystemId(storedItemDetail.getSourceSystemId());
				st.setDescription("Added missing status");
				st.setStatusId(UUID.randomUUID().toString());

				statusDao.save(st);
			}
		}

		// MetricsItemsStatusDuration table population

		MetricsItemsStatusTransition statusDetail = null;

		// find if data is present in table for from status
		if (fromStatus.length() > 0) {

			Long trnsDt = storedItemDetail.getLastUpdateDate();
			Long prevDt = storedItemDetail.getLastUpdateDate();

			List<MetricsItemsStatusTransition> data = metricsItemsStatusTransitionDao
					.findByItemIdAndToStatusOrderByTransitionDateDesc(itemId, fromStatus);

			if (data != null && data.size()>0) {

				statusDetail = data.get(0);
				prevDt = statusDetail.getTransitionDate();
				
			}

			Long dur = trnsDt - prevDt;
			
			MetricsItemsStatusDuration misd = new MetricsItemsStatusDuration();

			misd.setItemId(itemId);
			misd.setProjectId(webhookItem.getProjectId());
			misd.setSourceSystemId(webhookItem.getSourceSystemId());
			misd.setStatus(fromStatus);
			misd.setDuration(dur);
			misd.setStartDate(prevDt);

			MetricsItemsStatusDuration storedSDuration = metricsItemsStatusDurationDao.save(misd);
			storedItemDetail.addStatusDuration(storedSDuration);
		}

		// MetricsItemsTStatusTransition data population
		// get tvalue to for the from and to status values

		/*
		 * StatusTValueId toStatusTValueId = new StatusTValueId(toStatus,
		 * webhookItem.getSourceSystemId()); Optional<StatusTValue> toStatusTValue =
		 * statusTValueDao.findById(toStatusTValueId);
		 * 
		 * StatusTValueId fromStatusTValueId = new StatusTValueId(fromStatus,
		 * webhookItem.getSourceSystemId()); Optional<StatusTValue> fromStatusTValue =
		 * statusTValueDao.findById(fromStatusTValueId);
		 * 
		 * StatusTValue toStatustValueDetail = null; StatusTValue fromStatustValueDetail
		 * = null;
		 * 
		 * if (toStatusTValue != null && toStatusTValue.isPresent()) {
		 * 
		 * toStatustValueDetail = toStatusTValue.get(); }
		 * 
		 * if (fromStatusTValue != null && fromStatusTValue.isPresent()) {
		 * 
		 * fromStatustValueDetail = fromStatusTValue.get(); }
		 * 
		 * // find if data already exists in table
		 * Optional<MetricsItemsTStatusTransition> tStatusTransDetail = null;
		 * 
		 * if (toStatustValueDetail != null && fromStatustValueDetail != null) {
		 * MetricsItemsTStatusTransitionId toStatustStatusTransId = new
		 * MetricsItemsTStatusTransitionId( itemId,
		 * toStatustValueDetail.getCreateDate()); tStatusTransDetail =
		 * metricsItemsTStatusTransitionDao.findById(toStatustStatusTransId); }
		 * 
		 * // if data not present, insert data, else ignore if ((tStatusTransDetail ==
		 * null || !(tStatusTransDetail.isPresent())) && toStatustValueDetail != null &&
		 * fromStatustValueDetail != null) {
		 * 
		 * MetricsItemsTStatusTransition mitst = new MetricsItemsTStatusTransition();
		 * 
		 * mitst.setItemId(itemId); mitst.setProjectId(webhookItem.getProjectId());
		 * mitst.setSourceSystemId(webhookItem.getSourceSystemId());
		 * mitst.setStatus(toStatustValueDetail.getTValue());
		 * mitst.setTransitionDate(createDt);
		 * 
		 * MetricsItemsTStatusTransition storedTTrans =
		 * metricsItemsTStatusTransitionDao.save(mitst);
		 * storedItemDetail.addTStatusTransition(storedTTrans);
		 * 
		 * // MetricsItemsTStatusDuration data population
		 * 
		 * if (toStatustValueDetail.getTValue() != fromStatustValueDetail.getTValue()) {
		 * 
		 * // find if data for previous status exists MetricsItemsTStatusTransitionId
		 * fromStatustStatusTransId = new MetricsItemsTStatusTransitionId( itemId,
		 * fromStatustValueDetail.getCreateDate());
		 * 
		 * Optional<MetricsItemsTStatusTransition> prevTStatusTransDetail =
		 * metricsItemsTStatusTransitionDao .findById(fromStatustStatusTransId);
		 * 
		 * // if data for previous status exists, find duration, else ignore if
		 * (prevTStatusTransDetail != null && prevTStatusTransDetail.isPresent()) {
		 * 
		 * Long tStatusDur = createDt -
		 * prevTStatusTransDetail.get().getTransitionDate();
		 * 
		 * MetricsItemsTStatusDuration mitsd = new MetricsItemsTStatusDuration();
		 * 
		 * mitsd.setItemId(itemId); mitsd.setProjectId(webhookItem.getProjectId());
		 * mitsd.setSourceSystemId(webhookItem.getSourceSystemId());
		 * mitsd.setStatus(fromStatustValueDetail.getTValue());
		 * mitsd.setDuration(tStatusDur);
		 * 
		 * MetricsItemsTStatusDuration storedTSDuration =
		 * metricsItemsTStatusDurationDao.save(mitsd);
		 * storedItemDetail.addTStatusDuration(storedTSDuration);
		 * 
		 * }
		 * 
		 * }
		 * 
		 * }
		 */

		return storedItemDetail;
	}

	public void deleteAll() {
		metricsItemsCustomFieldDao.deleteAll();
		metricsItemsStatusDurationDao.deleteAll();
		metricsItemsStatusTransitionDao.deleteAll();
		metricsItemsTStatusDurationDao.deleteAll();
		metricsItemsTStatusDurationDao.deleteAll();
		metricsItemsDao.deleteAll();
	}

}
