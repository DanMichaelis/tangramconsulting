package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "eventUser")
@Table(name = "EventUser")
@IdClass(EventUserId.class)
public class EventUser implements Serializable{

		private static final long serialVersionUID = 1L;

		@Id
		private String id;

		@Id
		@Column(name = "SourceSystem")
		private int sourceSystem;

		@Column(name = "UserName")
		private String userName;

		@Column(name = "EmailId")
		private String emailId;

		@Column(name = "LastUpdateDate")
		private Long lastUpdateDate;

		
		private ArrayList<EventUserCustomField> eventUserCustomField;
		
		public ArrayList<EventUserCustomField> addCustomField(EventUserCustomField field){
			
			if (null == eventUserCustomField) {
				eventUserCustomField = new ArrayList<EventUserCustomField>();
			}
			
			if(null!= field) {
				if(!(field.getUserID().equals(this.getId()))) {
					throw new RuntimeException("FieldUserId doesnot match");
				}
				else {
					Boolean fieldPresent = false;
					for (EventUserCustomField f: eventUserCustomField) {
						if(f.getFieldName().equals(field.getFieldName())) {
							fieldPresent = true;
							f.setFieldValue(field.getFieldValue());
						}
					}
					
					if (!fieldPresent) {
						eventUserCustomField.add(field);
					}
				}
			}
			
			return eventUserCustomField;
		}
		
		
		public ArrayList<EventUserCustomField> getEventUserCustomField() {
			return eventUserCustomField;
		}

		public void setEventUserCustomField(ArrayList<EventUserCustomField> eventUserCustomField) {
			this.eventUserCustomField = eventUserCustomField;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getSourceSystem() {
			return sourceSystem;
		}

		public void setSourceSystem(int sourceSystem) {
			this.sourceSystem = sourceSystem;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public Long getLastUpdateDate() {
			return lastUpdateDate;
		}

		public void setLastUpdateDate(Long lastUpdateDate) {
			this.lastUpdateDate = lastUpdateDate;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public EventUser(String id, int sourceSystem, String userName, String emailId, Long lastUpdateDate) {
			super();
			this.id = id;
			this.sourceSystem = sourceSystem;
			this.userName = userName;
			this.emailId = emailId;
			this.lastUpdateDate = lastUpdateDate;
		}

		public EventUser() {
			super();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
			result = prime * result + ((lastUpdateDate == null) ? 0 : lastUpdateDate.hashCode());
			result = prime * result + sourceSystem;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((userName == null) ? 0 : userName.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			EventUser other = (EventUser) obj;
			if (emailId == null) {
				if (other.emailId != null)
					return false;
			} else if (!emailId.equals(other.emailId))
				return false;
			if (lastUpdateDate == null) {
				if (other.lastUpdateDate != null)
					return false;
			} else if (!lastUpdateDate.equals(other.lastUpdateDate))
				return false;
			if (sourceSystem != other.sourceSystem)
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (userName == null) {
				if (other.userName != null)
					return false;
			} else if (!userName.equals(other.userName))
				return false;
			return true;
		}

		
}
