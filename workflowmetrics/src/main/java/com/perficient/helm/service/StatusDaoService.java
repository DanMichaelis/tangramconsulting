package com.dtcc.workflowmetrics.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dtcc.workflowmetrics.dao.StatusCustomFieldDao;
import com.dtcc.workflowmetrics.dao.StatusDao;
import com.dtcc.workflowmetrics.dao.StatusTValueDao;
import com.dtcc.workflowmetrics.entity.Status;
import com.dtcc.workflowmetrics.entity.StatusCustomField;
import com.dtcc.workflowmetrics.entity.StatusId;
import com.dtcc.workflowmetrics.entity.StatusTValue;

@Service
public class StatusDaoService {

	@Autowired
	StatusDao statusDao;

	@Autowired
	StatusTValueDao statusTValueDao;

	@Autowired
	StatusCustomFieldDao statusCustomFieldDao;
	
	@Transactional
	public Status save(Status status) {
		
		Status storedStatusDetail = status;
		
//		boolean checkData = statusDao.existsStatusByCheckSum(status.getCheckSum());

//		if (!checkData) {
		
		Long createDt = System.currentTimeMillis();

		StatusId siData = new StatusId(status.getSourceSystemId(), status.getName());

		Optional<Status> statusData = statusDao.findById(siData);

		if (statusData == null || !statusData.isPresent()) {

			Status st = new Status();
			st.setName(status.getName());
			st.setLastUpdateDate(createDt);
			st.setSourceSystemId(status.getSourceSystemId());
			st.setDescription("Added missing status");
			st.setStatusId(UUID.randomUUID().toString());

			statusDao.save(st);
		}

		
			for (StatusCustomField sField : status.getStatusCustomField()) {
				sField.setCreateDate(status.getLastUpdateDate());
			}

			Iterable<StatusCustomField> storedFields = statusCustomFieldDao.saveAll(status.getStatusCustomField());

			for (StatusTValue sField : status.getStatusTValue()) {
				sField.setCreateDate(status.getLastUpdateDate());
			}

			Iterable<StatusTValue> storedTValues = statusTValueDao.saveAll(status.getStatusTValue());
//		}

		return storedStatusDetail;
	}

}
