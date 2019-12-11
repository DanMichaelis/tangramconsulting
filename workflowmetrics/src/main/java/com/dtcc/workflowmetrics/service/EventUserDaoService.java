package com.dtcc.workflowmetrics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dtcc.workflowmetrics.dao.EventUserCustomFieldDao;
import com.dtcc.workflowmetrics.dao.EventUserDao;
import com.dtcc.workflowmetrics.entity.EventUser;
import com.dtcc.workflowmetrics.entity.EventUserCustomField;

@Service
public class EventUserDaoService {

	@Autowired
	EventUserDao userDao;
	
	@Autowired
	EventUserCustomFieldDao customFieldDao;
	
	@Transactional
	public EventUser save(final EventUser user) {
		
		EventUser storedUserDetail = userDao.save(user);
		
		Iterable<EventUserCustomField> storedFields = customFieldDao.saveAll(user.getEventUserCustomField());
		
		for(EventUserCustomField sField:storedFields) {
			storedUserDetail.addCustomField(sField);
			
		}
		
		return storedUserDetail;
		
		
	}
	
	
	
	
}
