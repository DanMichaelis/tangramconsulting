package com.dtcc.workflowmetrics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dtcc.workflowmetrics.dao.StatusCustomFieldDao;
import com.dtcc.workflowmetrics.dao.StatusDao;
import com.dtcc.workflowmetrics.dao.StatusTValueDao;
import com.dtcc.workflowmetrics.entity.EventUser;
import com.dtcc.workflowmetrics.entity.EventUserCustomField;
import com.dtcc.workflowmetrics.entity.Status;
import com.dtcc.workflowmetrics.entity.StatusCustomField;
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
		
		boolean checkData = statusDao.existsStatusByCheckSum(status.getCheckSum());

		if (!checkData) {
			Status statusCopy = status.clone();

			statusCopy.setLastUpdateDate(System.currentTimeMillis());

			storedStatusDetail = statusDao.save(statusCopy);

			for (StatusCustomField sField : statusCopy.getStatusCustomField()) {
				sField.setCreateDate(statusCopy.getLastUpdateDate());
			}

			Iterable<StatusCustomField> storedFields = statusCustomFieldDao.saveAll(statusCopy.getStatusCustomField());

			for (StatusTValue sField : statusCopy.getStatusTValue()) {
				sField.setCreateDate(statusCopy.getLastUpdateDate());
			}

			Iterable<StatusTValue> storedTValues = statusTValueDao.saveAll(statusCopy.getStatusTValue());
		}

		return storedStatusDetail;
	}

}
