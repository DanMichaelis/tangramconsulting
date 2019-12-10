package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "eventUser")
@Table(name = "EventUser")
public class EventUser implements Serializable{

		private static final long serialVersionUID = 1L;

		@Id
		@Column(name = "UserID")
		private Integer userID;

		@Column(name = "SourceSystem")
		private int sourceSystem;

		@Column(name = "UserName")
		private String userName;

		@Column(name = "EmailId")
		private String emailId;

		@Column(name = "LastUpdateDate")
		private Long lastUpdateDate;

		public Integer getUserID() {
			return userID;
		}

		public void setUserID(Integer userID) {
			this.userID = userID;
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

		public EventUser(Integer userID, int sourceSystem, String userName, String emailId, Long lastUpdateDate) {
			super();
			this.userID = userID;
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
			result = prime * result + ((userID == null) ? 0 : userID.hashCode());
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
			if (userID == null) {
				if (other.userID != null)
					return false;
			} else if (!userID.equals(other.userID))
				return false;
			if (userName == null) {
				if (other.userName != null)
					return false;
			} else if (!userName.equals(other.userName))
				return false;
			return true;
		}

		
}
