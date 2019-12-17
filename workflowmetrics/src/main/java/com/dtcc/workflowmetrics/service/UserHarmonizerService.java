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
		
		int source = 12;
		EventUser evntUsr = new EventUser();
		
		evntUsr.setId(user.getKey());
		evntUsr.setEmailId(user.getEmailAddress());
		evntUsr.setUserName(user.getName());
		evntUsr.setSourceSystem(source);
		
		evntUsr.setLastUpdateDate(setLastUpdateDateforJira(user));

		String checksum = user.getKey() + Integer.toString(source) + user.getEmailAddress() + user.getName();
		
		ArrayList<EventUserCustomField> fields= new ArrayList<EventUserCustomField>();
		
		EventUserCustomField field = new EventUserCustomField(user.getKey(), 12, evntUsr.getLastUpdateDate(), "avatarUrls", "Hashmap", "ConvertAvatarHashmaptoString");
		fields.add(field);
		checksum = checksum + "avatarUrls" + "Hashmap" + "ConvertAvatarHashmaptoString";
		
		field = new EventUserCustomField(user.getKey(), 12, evntUsr.getLastUpdateDate(), "displayName", "String", user.getDisplayName());
		fields.add(field);
		
		checksum = checksum + "displayName" + "String" + user.getDisplayName();
		
		field = new EventUserCustomField(user.getKey(), 12, evntUsr.getLastUpdateDate(), "active", "Boolean", user.getActive().toString());
		fields.add(field);
		
		checksum = checksum + "active" + "Boolean" + user.getActive().toString();
		
		field = new EventUserCustomField(user.getKey(), 12, evntUsr.getLastUpdateDate(), "timeZone", "String", user.getTimeZone());
		fields.add(field);
		
		checksum = checksum + "timeZone" + "String" + user.getTimeZone();
		
		evntUsr.setCheckSum(checksum);
		
		evntUsr.setEventUserCustomField(fields);
		
		return evntUsr;
		
	}
	
	private Long setLastUpdateDateforJira(User user) {
		return System.currentTimeMillis();
	}
}
