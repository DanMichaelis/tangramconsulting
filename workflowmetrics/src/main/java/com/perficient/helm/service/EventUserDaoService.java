package com.perficient.helm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.perficient.helm.dao.EventUserCustomFieldDao;
import com.perficient.helm.dao.EventUserDao;
import com.perficient.helm.entity.EventUser;
import com.perficient.helm.entity.EventUserCustomField;

@Service
public class EventUserDaoService {

	@Autowired
	EventUserDao userDao;

	@Autowired
	EventUserCustomFieldDao customFieldDao;

	@Transactional
	public EventUser save(EventUser user) {

		EventUser storedUserDetail = user;

		boolean checkData = userDao.existsEventUserByCheckSum(user.getCheckSum());

		if (!checkData) {
			EventUser userCopy = user.clone();

			userCopy.setLastUpdateDate(System.currentTimeMillis());

			storedUserDetail = userDao.save(userCopy);

			for (EventUserCustomField sField : userCopy.getEventUserCustomField()) {
				sField.setCreateDate(userCopy.getLastUpdateDate());
			}

			Iterable<EventUserCustomField> storedFields = customFieldDao.saveAll(userCopy.getEventUserCustomField());

		}
		
		return storedUserDetail;

	}

}
