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
import com.dtcc.workflowmetrics.entity.MetricsItemsTStatusDuration;
import com.dtcc.workflowmetrics.entity.MetricsItemsTStatusTransition;
import com.dtcc.workflowmetrics.entity.MetricsItemsTStatusTransitionId;
import com.dtcc.workflowmetrics.entity.Status;
import com.dtcc.workflowmetrics.entity.StatusId;
import com.dtcc.workflowmetrics.entity.StatusTValue;
import com.dtcc.workflowmetrics.entity.StatusTValueId;

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

	Long createDt = System.currentTimeMillis();

	@Transactional
	public MetricsItems save(MetricsItems webhookItem) {

		// call method to save Metrics Items table data

		MetricsItems storedItemDetail = null;
		storedItemDetail = saveMetricsItem(webhookItem);

		// call method to save MetricsItemsCustomField table data
		storedItemDetail = saveMetricsItemsCustomField(webhookItem, storedItemDetail);

		// call method to save Data for Tables MetricsItemsStatusTransition,
		// MetricsItemsStatusDuration, MetricsItemsTStatusTransition,
		// MetricsItemsTStatusDuration
		storedItemDetail = saveMetricsItemsStatusTablesData(webhookItem, storedItemDetail);

		return storedItemDetail;
	}

	// Save MetricsItems table data
	private MetricsItems saveMetricsItem(MetricsItems webhookItem) {

		MetricsItems itemDetail = new MetricsItems();

		MetricsItemsId mid = new MetricsItemsId(webhookItem.getItemKey(), webhookItem.getSourceSystemId());

		Optional<MetricsItems> storedData = metricsItemsDao.findById(mid);

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

		return storedItemDetail;
	}

	// save MetricsItemsCustomField table data
	private MetricsItems saveMetricsItemsCustomField(MetricsItems webhookItem, MetricsItems storedItemDetail) {

		for (MetricsItemsCustomField cField : webhookItem.getMetricsItemsCustomField()) {
			MetricsItemsCustomField custFld = new MetricsItemsCustomField();

			MetricsItemsCustomFieldId custFldId = new MetricsItemsCustomFieldId(storedItemDetail.getItemId(),
					cField.getFieldName());

			Optional<MetricsItemsCustomField> storedCustomField = metricsItemsCustomFieldDao.findById(custFldId);

			// if data is not present, add data, else update data
			if (storedCustomField != null && storedCustomField.isPresent()) {
				custFld = storedCustomField.get();
			} else {
				custFld.setItemId(storedItemDetail.getItemId());
				custFld.setCreateDate(createDt);
				custFld.setFieldName(cField.getFieldName());
				custFld.setFieldDatatype("CustomField");
				custFld.setSourceSystemId(storedItemDetail.getSourceSystemId());
			}
			custFld.setFieldValue(cField.getFieldValue());

			MetricsItemsCustomField storedCustField = metricsItemsCustomFieldDao.save(custFld);

			storedItemDetail.addCustomField(storedCustField);
		}

		return storedItemDetail;
	}

	// save Data for Tables MetricsItemsStatusTransition,
	// MetricsItemsStatusDuration, MetricsItemsTStatusTransition,
	// MetricsItemsTStatusDuration
	private MetricsItems saveMetricsItemsStatusTablesData(MetricsItems webhookItem, MetricsItems storedItemDetail) {
		String fromStatus = null;
		String toStatus = null;
		Long transitionTime = null;

		for (MetricsItemsStatusTransition statusField : webhookItem.getMetricsItemsStatusTransition()) {

			// call method to save MetricsItemsStatusTransition data
			MetricsItemsStatusTransition storedStatusTrans = saveMetricsItemsStatusTransition(statusField,
					storedItemDetail);

			fromStatus = storedStatusTrans.getFromStatus();
			toStatus = storedStatusTrans.getToStatus();
			transitionTime = storedStatusTrans.getTransitionDate();

			storedItemDetail.addStatusTransition(storedStatusTrans);
		}

		if (fromStatus.length() > 0) {

			// call method to save MetricsItemsStatusDuration data
			storedItemDetail = saveMetricsItemsStatusDuration(storedItemDetail, fromStatus);
		}

		// call method to save MetricsItemsTStatusTransition data
		storedItemDetail = saveMetricsItemsTStatusTables(fromStatus, toStatus, transitionTime, webhookItem,
				storedItemDetail);

		return storedItemDetail;
	}

	// save MetricsItemsStatusTransition data
	private MetricsItemsStatusTransition saveMetricsItemsStatusTransition(MetricsItemsStatusTransition statusField,
			MetricsItems storedItemDetail) {

		MetricsItemsStatusTransition statusFld = new MetricsItemsStatusTransition();

		MetricsItemsStatusTransitionId statusTransitionId = new MetricsItemsStatusTransitionId(
				storedItemDetail.getItemId(), statusField.getTransitionDate());

		Optional<MetricsItemsStatusTransition> storedStatusTransitionField = metricsItemsStatusTransitionDao
				.findById(statusTransitionId);

		// if data is not present, add data, else update data
		if (storedStatusTransitionField != null && storedStatusTransitionField.isPresent()) {
			statusFld = storedStatusTransitionField.get();
		} else {
			statusFld.setItemId(storedItemDetail.getItemId());
			statusFld.setSourceSystemId(storedItemDetail.getSourceSystemId());
			statusFld.setProjectId(storedItemDetail.getProjectId());
			statusFld.setFromStatus(statusField.getFromStatus());
			statusFld.setToStatus(statusField.getToStatus());
			statusFld.setTransitionDate(statusField.getTransitionDate());
		}

		MetricsItemsStatusTransition storedStatusTrans = metricsItemsStatusTransitionDao.save(statusFld);

		return storedStatusTrans;

	}

	// save MetricsItemsStatusDuration data
	private MetricsItems saveMetricsItemsStatusDuration(MetricsItems storedItemDetail, String fromStatus) {

		MetricsItemsStatusTransition statusDetail = null;

		Long trnsDt = storedItemDetail.getLastUpdateDate();
		Long prevDt = storedItemDetail.getLastUpdateDate();

		List<MetricsItemsStatusTransition> data = metricsItemsStatusTransitionDao
				.findByItemIdAndToStatusOrderByTransitionDateDesc(storedItemDetail.getItemId(), fromStatus);

		if (data != null && data.size() > 0) {

			statusDetail = data.get(0);
			prevDt = statusDetail.getTransitionDate();

		}

		Long dur = trnsDt - prevDt;

		MetricsItemsStatusDuration misd = new MetricsItemsStatusDuration();

		misd.setItemId(storedItemDetail.getItemId());
		misd.setProjectId(storedItemDetail.getProjectId());
		misd.setSourceSystemId(storedItemDetail.getSourceSystemId());
		misd.setStatus(fromStatus);
		misd.setDuration(dur);
		misd.setStartDate(prevDt);

		MetricsItemsStatusDuration storedSDuration = metricsItemsStatusDurationDao.save(misd);
		storedItemDetail.addStatusDuration(storedSDuration);

		return storedItemDetail;
	}

	// save data for MetricsItemsTStatusTransition and MetricsItemsTStatusDuration
	// tables
	private MetricsItems saveMetricsItemsTStatusTables(String fromStatus, String toStatus, Long transitionTime,
			MetricsItems webhookItem, MetricsItems storedItemDetail) {

		// check if from and to status are present in status table, if not, add data
		String fromStatusId = saveStatusData(fromStatus, storedItemDetail.getSourceSystemId());
		String toStatusId = saveStatusData(toStatus, storedItemDetail.getSourceSystemId());

		StatusTValueId toStatusTValueId = new StatusTValueId(toStatusId, webhookItem.getSourceSystemId());
		Optional<StatusTValue> toStatusTValue = statusTValueDao.findById(toStatusTValueId);

		StatusTValueId fromStatusTValueId = new StatusTValueId(fromStatusId, webhookItem.getSourceSystemId());
		Optional<StatusTValue> fromStatusTValue = statusTValueDao.findById(fromStatusTValueId);

		int toStatustValueDetail = -1;
		int fromStatustValueDetail = -1;

		if (toStatusTValue != null && toStatusTValue.isPresent()) {

			toStatustValueDetail = toStatusTValue.get().getTValue();
		}

		if (fromStatusTValue != null && fromStatusTValue.isPresent()) {

			fromStatustValueDetail = fromStatusTValue.get().getTValue();
		}

		if (toStatustValueDetail != fromStatustValueDetail) {

			// call method to save MetricsItemTStatusTransition data and
			// MetricsItemTStatusDuration data

			storedItemDetail = saveMetricsItemsTStatusTransition(storedItemDetail, transitionTime,
					fromStatustValueDetail, toStatustValueDetail, fromStatus);
		}
		return storedItemDetail;
	}

	// save MetricsItemsTStatusTransition Table data
	private MetricsItems saveMetricsItemsTStatusTransition(MetricsItems storedItemDetail, Long transitionTime,
			int fromStatustValueDetail, int toStatustValueDetail, String fromStatus) {

		// find if data already exists in table
		Optional<MetricsItemsTStatusTransition> tStatusTransDetail = null;

		MetricsItemsTStatusTransitionId tStatusTransId = new MetricsItemsTStatusTransitionId(
				storedItemDetail.getItemId(), transitionTime);
		tStatusTransDetail = metricsItemsTStatusTransitionDao.findById(tStatusTransId);

		// if data not present, insert data, else ignore
		if (tStatusTransDetail == null || !tStatusTransDetail.isPresent()) {

			MetricsItemsTStatusTransition mitst = new MetricsItemsTStatusTransition();

			if (fromStatustValueDetail == -1) {
				fromStatustValueDetail = 0;
			}
			
			if (toStatustValueDetail >=0){
			
			mitst.setItemId(storedItemDetail.getItemId());
			mitst.setProjectId(storedItemDetail.getProjectId());
			mitst.setSourceSystemId(storedItemDetail.getSourceSystemId());
			mitst.setStatus(toStatustValueDetail);
			mitst.setTransitionDate(transitionTime);

			MetricsItemsTStatusTransition storedTTrans = metricsItemsTStatusTransitionDao.save(mitst);
			storedItemDetail.addTStatusTransition(storedTTrans);
			}
			
			if (fromStatus.length() > 0) {

				// call method to save MetricsItemsTStatusDuration data
				storedItemDetail = saveMetricsItemsTStatusDuration(storedItemDetail, fromStatustValueDetail,
						toStatustValueDetail);
			}

		}

		return storedItemDetail;
	}

	// save MetricsItemsTStatusDuration table data
	private MetricsItems saveMetricsItemsTStatusDuration(MetricsItems storedItemDetail, int fromStatustValueDetail,
			int toStatustValueDetail) {

		List<MetricsItemsTStatusTransition> prevTStatusTransDetail = metricsItemsTStatusTransitionDao
				.findByItemIdAndStatusOrderByTransitionDateDesc(storedItemDetail.getItemId(), fromStatustValueDetail);

		List<MetricsItemsTStatusTransition> presentTStatusTransDetail = metricsItemsTStatusTransitionDao
				.findByItemIdAndStatusOrderByTransitionDateDesc(storedItemDetail.getItemId(), toStatustValueDetail);

		Long trnsDt = storedItemDetail.getLastUpdateDate();
		Long prevDt = storedItemDetail.getLastUpdateDate();

		// if data for previous status exists, find duration, else ignore
		if (prevTStatusTransDetail != null && prevTStatusTransDetail.size() > 0 && presentTStatusTransDetail != null
				&& presentTStatusTransDetail.size() > 0) {

			prevDt = prevTStatusTransDetail.get(0).getTransitionDate();

			trnsDt = presentTStatusTransDetail.get(0).getTransitionDate();

			Long tStatusDur = trnsDt - prevDt;

			MetricsItemsTStatusDuration mitsd = new MetricsItemsTStatusDuration();

			mitsd.setItemId(storedItemDetail.getItemId());
			mitsd.setProjectId(storedItemDetail.getProjectId());
			mitsd.setSourceSystemId(storedItemDetail.getSourceSystemId());
			mitsd.setStatus(fromStatustValueDetail);
			mitsd.setDuration(tStatusDur);
			mitsd.setStartDate(prevDt);

			MetricsItemsTStatusDuration storedTSDuration = metricsItemsTStatusDurationDao.save(mitsd);
			storedItemDetail.addTStatusDuration(storedTSDuration);

		}

		return storedItemDetail;

	}

	// save data for Status Table
	private String saveStatusData(String status, int sourceId) {
		String statusId = null;

		if (status.length() > 0) {
			StatusId siFromData = new StatusId(sourceId, status);
			Optional<Status> fromStatusData = statusDao.findById(siFromData);
			if (fromStatusData != null && fromStatusData.isPresent()) {
				statusId = fromStatusData.get().getStatusId();
			} else {

				Status st = new Status();
				st.setName(status);
				st.setLastUpdateDate(createDt);
				st.setSourceSystemId(sourceId);
				st.setDescription("Added missing status");
				st.setStatusId(UUID.randomUUID().toString());

				statusDao.save(st);
			}
		}

		return statusId;
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
