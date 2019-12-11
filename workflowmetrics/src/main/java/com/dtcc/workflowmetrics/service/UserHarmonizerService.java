package com.dtcc.workflowmetrics.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dtcc.workflowmetrics.entity.EventUser;
import com.dtcc.workflowmetrics.entity.EventUserCustomField;
import com.dtcc.workflowmetrics.metricsitems.jira.common.User;

@Service
public class UserHarmonizerService {

	@Transactional
	public final EventUser harmonizeJiraUser(User user) {
		
		EventUser evntUsr = new EventUser();
		
		evntUsr.setId(user.getKey());
		evntUsr.setEmailId(user.getEmailAddress());
		evntUsr.setUserName(user.getName());
		evntUsr.setSourceSystem(12);
		
		evntUsr.setLastUpdateDate(setLastUpdateDateforJira(user));

		ArrayList<EventUserCustomField> fields= new ArrayList<EventUserCustomField>();
		
		EventUserCustomField field = new EventUserCustomField(user.getKey(), 12, evntUsr.getLastUpdateDate(), "avatarUrls", "Hashmap", "ConvertAvatarHashmaptoString");
		fields.add(field);
		field = new EventUserCustomField(user.getKey(), 12, evntUsr.getLastUpdateDate(), "displayName", "String", user.getDisplayName());
		fields.add(field);
		field = new EventUserCustomField(user.getKey(), 12, evntUsr.getLastUpdateDate(), "active", "Boolean", user.getActive().toString());
		fields.add(field);
		field = new EventUserCustomField(user.getKey(), 12, evntUsr.getLastUpdateDate(), "timeZone", "String", user.getTimeZone());
		fields.add(field);
		
		evntUsr.setEventUserCustomField(fields);
		
		return evntUsr;
		
	}
	
	private Long setLastUpdateDateforJira(User user) {
		return System.currentTimeMillis();
	}
}
