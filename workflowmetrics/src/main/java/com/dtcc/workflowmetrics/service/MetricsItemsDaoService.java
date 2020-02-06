package com.dtcc.workflowmetrics.service;

import java.util.List;
import java.util.Optional;

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
import com.dtcc.workflowmetrics.entity.MetricsItemsStatusDuration;
import com.dtcc.workflowmetrics.entity.MetricsItemsStatusTransition;
import com.dtcc.workflowmetrics.entity.MetricsItemsTStatusDuration;
import com.dtcc.workflowmetrics.entity.MetricsItemsTStatusTransition;
import com.dtcc.workflowmetrics.entity.MetricsItemsTStatusTransitionId;
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

	@Transactional
	public MetricsItems save(MetricsItems item) {

		MetricsItems storedItemDetail = item;

		// check if data already exists in Metrics Items table
		boolean checkData = metricsItemsDao.existsMetricsItemsByCheckSum(item.getCheckSum());

		// if data is not present, add data
		if (!checkData) {
			MetricsItems itemCopy = item.clone();

			Long createDt = System.currentTimeMillis();

			itemCopy.setItemCreateDate(createDt);

			itemCopy.setLastUpdateDate(createDt);

			storedItemDetail = metricsItemsDao.save(itemCopy);

			// MetricsItemsCustomField
			for (MetricsItemsCustomField cField : storedItemDetail.getMetricsItemsCustomField()) {
				cField.setCreateDate(itemCopy.getLastUpdateDate());
			}

			Iterable<MetricsItemsCustomField> storedFields = metricsItemsCustomFieldDao
					.saveAll(storedItemDetail.getMetricsItemsCustomField());

			// MetricsItemsStatusTransition table population
			// check if data is present in table

			List<MetricsItemsStatusTransition> resultDetails = metricsItemsStatusTransitionDao
					.findByOrderByTransitionDateDesc();

			String fromStatus = null;
			String toStatus = null;

			MetricsItemsStatusTransition mist = new MetricsItemsStatusTransition();

			for (MetricsItemsStatusTransition sTrans : itemCopy.getMetricsItemsStatusTransition()) {
				fromStatus = sTrans.getFromStatus();
				toStatus = sTrans.getToStatus();

				if (resultDetails.size() > 0) {
					MetricsItemsStatusTransition result = resultDetails.get(1);
					mist.setItemId(result.getItemId());
					mist.setProjectId(result.getProjectId());
					mist.setSourceSystemId(result.getSourceSystemId());
					mist.setFromStatus(sTrans.getFromStatus());
					mist.setToStatus(sTrans.getToStatus());
					mist.setTransitionDate(createDt);

				} else {
					mist.setItemId(itemCopy.getItemId());
					mist.setProjectId(itemCopy.getProjectId());
					mist.setSourceSystemId(itemCopy.getSourceSystemId());
					mist.setFromStatus(sTrans.getFromStatus());
					mist.setTransitionDate(createDt);
					mist.setToStatus(sTrans.getToStatus());

				}

				MetricsItemsStatusTransition storedStatusTrans = metricsItemsStatusTransitionDao.save(mist);
				storedItemDetail.addStatusTransition(storedStatusTrans);

			}

			// MetricsItemsStatusDuration table population

			MetricsItemsStatusTransition statusDetail = null;

			// find if data is present in table for from status
			Optional<MetricsItemsStatusTransition> data = metricsItemsStatusTransitionDao
					.findByItemIdAndProjectIdAndSourceSystemIdAndToStatus(itemCopy.getItemId(), itemCopy.getProjectId(),
							itemCopy.getSourceSystemId(), fromStatus);

			Long dur;

			if (data != null && data.isPresent()) {

				statusDetail = data.get();
				dur = createDt - statusDetail.getTransitionDate();
			}

			else
				dur = Long.valueOf("0");

			MetricsItemsStatusDuration misd = new MetricsItemsStatusDuration();

			misd.setItemId(itemCopy.getItemId());
			misd.setProjectId(itemCopy.getProjectId());
			misd.setSourceSystemId(itemCopy.getSourceSystemId());
			misd.setStatus(fromStatus);
			misd.setDuration(dur);

			MetricsItemsStatusDuration storedSDuration = metricsItemsStatusDurationDao.save(misd);
			storedItemDetail.addStatusDuration(storedSDuration);

			// MetricsItemsTStatusTransition data population
			// get tvalue to for the from and to status values
			StatusTValueId toStatusTValueId = new StatusTValueId(toStatus, itemCopy.getSourceSystemId());
			Optional<StatusTValue> toStatusTValue = statusTValueDao.findById(toStatusTValueId);

			StatusTValueId fromStatusTValueId = new StatusTValueId(fromStatus, itemCopy.getSourceSystemId());
			Optional<StatusTValue> fromStatusTValue = statusTValueDao.findById(fromStatusTValueId);

			StatusTValue toStatustValueDetail = null;
			StatusTValue fromStatustValueDetail = null;

			if (toStatusTValue != null && toStatusTValue.isPresent()) {

				toStatustValueDetail = toStatusTValue.get();
			}

			if (fromStatusTValue != null && fromStatusTValue.isPresent()) {

				fromStatustValueDetail = fromStatusTValue.get();
			}

			// find if data already exists in table
			Optional<MetricsItemsTStatusTransition> tStatusTransDetail = null;

			if (toStatustValueDetail != null && fromStatustValueDetail != null) {
				MetricsItemsTStatusTransitionId toStatustStatusTransId = new MetricsItemsTStatusTransitionId(
						itemCopy.getItemId(), itemCopy.getProjectId(), itemCopy.getSourceSystemId(),
						toStatustValueDetail.getTValue());
				tStatusTransDetail = metricsItemsTStatusTransitionDao.findById(toStatustStatusTransId);
			}
			
			// if data not present, insert data, else ignore
			if (tStatusTransDetail == null || !(tStatusTransDetail.isPresent())) {

				MetricsItemsTStatusTransition mitst = new MetricsItemsTStatusTransition();

				mitst.setItemId(itemCopy.getItemId());
				mitst.setProjectId(itemCopy.getProjectId());
				mitst.setSourceSystemId(itemCopy.getSourceSystemId());
				mitst.setStatus(toStatustValueDetail.getTValue());
				mitst.setTransitionDate(createDt);

				MetricsItemsTStatusTransition storedTTrans = metricsItemsTStatusTransitionDao.save(mitst);
				storedItemDetail.addTStatusTransition(storedTTrans);

				// MetricsItemsTStatusDuration data population

				if (toStatustValueDetail != null && fromStatustValueDetail != null && toStatustValueDetail.getTValue() != fromStatustValueDetail.getTValue()) {

					// find if data for previous status exists
					MetricsItemsTStatusTransitionId fromStatustStatusTransId = new MetricsItemsTStatusTransitionId(
							itemCopy.getItemId(), itemCopy.getProjectId(), itemCopy.getSourceSystemId(),
							fromStatustValueDetail.getTValue());
					Optional<MetricsItemsTStatusTransition> prevTStatusTransDetail = metricsItemsTStatusTransitionDao
							.findById(fromStatustStatusTransId);

					// if data for previous status exists, find duration, else ignore
					if (prevTStatusTransDetail != null && prevTStatusTransDetail.isPresent()) {

						Long tStatusDur = createDt - prevTStatusTransDetail.get().getTransitionDate();

						MetricsItemsTStatusDuration mitsd = new MetricsItemsTStatusDuration();

						mitsd.setItemId(itemCopy.getItemId());
						mitsd.setProjectId(itemCopy.getProjectId());
						mitsd.setSourceSystemId(itemCopy.getSourceSystemId());
						mitsd.setStatus(fromStatustValueDetail.getTValue());
						mitsd.setDuration(tStatusDur);

						MetricsItemsTStatusDuration storedTSDuration = metricsItemsTStatusDurationDao.save(mitsd);
						storedItemDetail.addTStatusDuration(storedTSDuration);

					}

				}

			}

		}

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
