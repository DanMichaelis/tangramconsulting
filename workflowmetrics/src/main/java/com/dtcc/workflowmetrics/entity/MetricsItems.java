package com.dtcc.workflowmetrics.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "metricsItems")
@Table(name = "MetricsItems")
@IdClass(MetricsItemsId.class)
public class MetricsItems implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String itemId;

	@Id
	@Column(name = "SourceSystemId")
	private int sourceSystemId;

	@Column(name = "ItemKey")
	private String itemKey;

	@Column(name = "ProjectId")
	private String projectId;

	@Column(name = "ItemSummary")
	private String itemSummary;

	@Column(name = "ItemDescription")
	private String itemDescription;

	@Column(name = "ItemCreateDate")
	private Long itemCreateDate;

	@Column(name = "ItemCreator")
	private String itemCreator;

	@Column(name = "LastUpdateDate")
	private Long lastUpdateDate;

	@Column(name = "LastUpdateUser")
	private String lastUpdateUser;

	@Column(name = "CheckSum", length = 5000)
	private String checkSum;

	private ArrayList<MetricsItemsCustomField> metricsItemsCustomField;

	private ArrayList<MetricsItemsTStatusTransition> metricsItemsTStatusTransition;

	private ArrayList<MetricsItemsStatusTransition> metricsItemsStatusTransition;

	private ArrayList<MetricsItemsStatusDuration> metricsItemsStatusDuration;

	private ArrayList<MetricsItemsTStatusDuration> metricsItemsTStatusDuration;

	public final String getItemId() {
		return itemId;
	}

	public final MetricsItems setItemId(String itemId) {
		this.itemId = itemId;
		return this;
	}

	public final int getSourceSystemId() {
		return sourceSystemId;
	}

	public final MetricsItems setSourceSystemId(int sourceSystemId) {
		this.sourceSystemId = sourceSystemId;

		return this;
	}

	public final String getItemKey() {
		return itemKey;
	}

	public final MetricsItems setItemKey(String itemKey) {
		this.itemKey = itemKey;
		return this;
	}

	public final String getProjectId() {
		return projectId;
	}

	public final MetricsItems setProjectId(String projectId) {
		this.projectId = projectId;
		return this;
	}

	public final String getItemSummary() {
		return itemSummary;
	}

	public final MetricsItems setItemSummary(String itemSummary) {
		this.itemSummary = itemSummary;
		return this;
	}

	public final String getItemDescription() {
		return itemDescription;
	}

	public final MetricsItems setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
		return this;
	}

	public final Long getItemCreateDate() {
		return itemCreateDate;
	}

	public final MetricsItems setItemCreateDate(Long itemCreateDate) {
		this.itemCreateDate = itemCreateDate;
		return this;
	}

	public final String getItemCreator() {
		return itemCreator;
	}

	public final MetricsItems setItemCreator(String itemCreator) {
		this.itemCreator = itemCreator;
		return this;
	}

	public final Long getLastUpdateDate() {
		return lastUpdateDate;
	}

	public final MetricsItems setLastUpdateDate(Long lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
		return this;
	}

	public final String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public final MetricsItems setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
		return this;
	}

	public final String getCheckSum() {
		return checkSum;
	}

	public final MetricsItems setCheckSum(String checkSum) {
		this.checkSum = checkSum;
		return this;
	}

	public final ArrayList<MetricsItemsCustomField> getMetricsItemsCustomField() {
		return metricsItemsCustomField;
	}

	public final MetricsItems setMetricsItemsCustomField(ArrayList<MetricsItemsCustomField> metricsItemsCustomField) {
		this.metricsItemsCustomField = metricsItemsCustomField;
		return this;
	}

	public final ArrayList<MetricsItemsTStatusTransition> getMetricsItemsTStatusTransition() {
		return metricsItemsTStatusTransition;
	}

	public final MetricsItems setMetricsItemsTStatusTransition(
			ArrayList<MetricsItemsTStatusTransition> metricsItemsTStatusTransition) {
		this.metricsItemsTStatusTransition = metricsItemsTStatusTransition;
		return this;
	}

	public final ArrayList<MetricsItemsStatusTransition> getMetricsItemsStatusTransition() {
		return metricsItemsStatusTransition;
	}

	public final MetricsItems setMetricsItemsStatusTransition(
			ArrayList<MetricsItemsStatusTransition> metricsItemsStatusTransition) {
		this.metricsItemsStatusTransition = metricsItemsStatusTransition;
		return this;
	}

	public final ArrayList<MetricsItemsStatusDuration> getMetricsItemsStatusDuration() {
		return metricsItemsStatusDuration;
	}

	public final MetricsItems setMetricsItemsStatusDuration(
			ArrayList<MetricsItemsStatusDuration> metricsItemsStatusDuration) {
		this.metricsItemsStatusDuration = metricsItemsStatusDuration;
		return this;
	}

	public final ArrayList<MetricsItemsTStatusDuration> getMetricsItemsTStatusDuration() {
		return metricsItemsTStatusDuration;
	}

	public final MetricsItems setMetricsItemsTStatusDuration(
			ArrayList<MetricsItemsTStatusDuration> metricsItemsTStatusDuration) {
		this.metricsItemsTStatusDuration = metricsItemsTStatusDuration;
		return this;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private MetricsItems(MetricsItems m) {

		this.itemId = m.itemId;
		this.sourceSystemId = m.sourceSystemId;
		this.itemKey = m.itemKey;
		this.projectId = m.projectId;
		this.itemSummary = m.itemSummary;
		this.itemDescription = m.itemDescription;
		this.itemCreateDate = m.itemCreateDate;
		this.itemCreator = m.itemCreator;
		this.lastUpdateDate = m.lastUpdateDate;
		this.lastUpdateUser = m.lastUpdateUser;
		metricsItemsCustomField = new ArrayList<MetricsItemsCustomField>();
		for (MetricsItemsCustomField cf : m.getMetricsItemsCustomField()) {
			metricsItemsCustomField.add(cf.clone());
		}
		metricsItemsTStatusTransition = new ArrayList<MetricsItemsTStatusTransition>();
		for (MetricsItemsTStatusTransition st : m.getMetricsItemsTStatusTransition()) {
			metricsItemsTStatusTransition.add(st.clone());
		}
		metricsItemsStatusTransition = new ArrayList<MetricsItemsStatusTransition>();
		for (MetricsItemsStatusTransition st : m.getMetricsItemsStatusTransition()) {
			metricsItemsStatusTransition.add(st.clone());
		}
		metricsItemsStatusDuration = new ArrayList<MetricsItemsStatusDuration>();
		for (MetricsItemsStatusDuration sd : m.getMetricsItemsStatusDuration()) {
			metricsItemsStatusDuration.add(sd.clone());
		}
		metricsItemsTStatusDuration = new ArrayList<MetricsItemsTStatusDuration>();
		for (MetricsItemsTStatusDuration sd : m.getMetricsItemsTStatusDuration()) {
			metricsItemsTStatusDuration.add(sd.clone());
		}
	}

	public MetricsItems(String itemId, int sourceSystemId, String itemKey, String projectId, String itemSummary,
			String itemDescription, Long itemCreateDate, String itemCreator, Long lastUpdateDate, String lastUpdateUser,
			String checkSum, ArrayList<MetricsItemsCustomField> metricsItemsCustomField,
			ArrayList<MetricsItemsTStatusTransition> metricsItemsTStatusTransition,
			ArrayList<MetricsItemsStatusTransition> metricsItemsStatusTransition,
			ArrayList<MetricsItemsStatusDuration> metricsItemsStatusDuration,
			ArrayList<MetricsItemsTStatusDuration> metricsItemsTStatusDuration) {
		super();
		this.itemId = itemId;
		this.sourceSystemId = sourceSystemId;
		this.itemKey = itemKey;
		this.projectId = projectId;
		this.itemSummary = itemSummary;
		this.itemDescription = itemDescription;
		this.itemCreateDate = itemCreateDate;
		this.itemCreator = itemCreator;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateUser = lastUpdateUser;
		this.checkSum = calculateChecksum();
		this.metricsItemsCustomField = metricsItemsCustomField;
		this.metricsItemsTStatusTransition = metricsItemsTStatusTransition;
		this.metricsItemsStatusTransition = metricsItemsStatusTransition;
		this.metricsItemsStatusDuration = metricsItemsStatusDuration;
		this.metricsItemsTStatusDuration = metricsItemsTStatusDuration;
	}

	public MetricsItems(String itemId, int sourceSystemId, String itemKey, String projectId, String itemSummary,
			String itemDescription, Long itemCreateDate, String itemCreator, Long lastUpdateDate, String lastUpdateUser,
			ArrayList<MetricsItemsCustomField> metricsItemsCustomField,
			ArrayList<MetricsItemsTStatusTransition> metricsItemsTStatusTransition,
			ArrayList<MetricsItemsStatusTransition> metricsItemsStatusTransition,
			ArrayList<MetricsItemsStatusDuration> metricsItemsStatusDuration,
			ArrayList<MetricsItemsTStatusDuration> metricsItemsTStatusDuration) {
		super();
		this.itemId = itemId;
		this.sourceSystemId = sourceSystemId;
		this.itemKey = itemKey;
		this.projectId = projectId;
		this.itemSummary = itemSummary;
		this.itemDescription = itemDescription;
		this.itemCreateDate = itemCreateDate;
		this.itemCreator = itemCreator;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateUser = lastUpdateUser;
		this.checkSum = calculateChecksum();
		this.metricsItemsCustomField = metricsItemsCustomField;
		this.metricsItemsTStatusTransition = metricsItemsTStatusTransition;
		this.metricsItemsStatusTransition = metricsItemsStatusTransition;
		this.metricsItemsStatusDuration = metricsItemsStatusDuration;
		this.metricsItemsTStatusDuration = metricsItemsTStatusDuration;
	}

	public MetricsItems() {
		super();
	}

	private String calculateChecksum() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.toStringWithoutCustomFieldsAndDates());

		for (MetricsItemsCustomField f : metricsItemsCustomField) {
			sb.append(f.toStringWithoutCreateDate());
		}
		for (MetricsItemsTStatusTransition t : metricsItemsTStatusTransition) {
			sb.append(t.toStringWithoutDate());
		}
		for (MetricsItemsStatusTransition t : metricsItemsStatusTransition) {
			sb.append(t.toStringWithoutDate());
		}
		for (MetricsItemsStatusDuration d : metricsItemsStatusDuration) {
			sb.append(d.toStringWithoutDuration());
		}
		for (MetricsItemsTStatusDuration d : metricsItemsTStatusDuration) {
			sb.append(d.toStringWithoutDuration());
		}
		return ChecksumUtil.getChecksum(sb.toString());
	}

	public MetricsItems clone() {
		MetricsItems clone = new MetricsItems();
		clone.setItemId(this.itemId);
		clone.setSourceSystemId(this.sourceSystemId);
		clone.setItemKey(this.itemKey);
		clone.setProjectId(this.projectId);
		clone.setItemSummary(this.itemSummary);
		clone.setItemDescription(this.itemDescription);
		clone.setItemCreateDate(this.itemCreateDate);
		clone.setItemCreator(this.itemCreator);
		clone.setLastUpdateDate(this.lastUpdateDate);
		clone.setLastUpdateUser(this.lastUpdateUser);

		
		ArrayList<MetricsItemsCustomField> custFldArr = new ArrayList<MetricsItemsCustomField>();

		for (MetricsItemsCustomField e : this.metricsItemsCustomField) {

			custFldArr.add(new MetricsItemsCustomField(e));

		}
		clone.setMetricsItemsCustomField(custFldArr);
		

		ArrayList<MetricsItemsTStatusTransition> mTranSrr = new ArrayList<MetricsItemsTStatusTransition>();

		for (MetricsItemsTStatusTransition t : this.metricsItemsTStatusTransition) {

			mTranSrr.add(new MetricsItemsTStatusTransition(t));

		}
		clone.setMetricsItemsTStatusTransition(mTranSrr);

		ArrayList<MetricsItemsStatusTransition> tran = new ArrayList<MetricsItemsStatusTransition>();

		for (MetricsItemsStatusTransition t : this.metricsItemsStatusTransition) {

			tran.add(new MetricsItemsStatusTransition(t));

		}
		clone.setMetricsItemsStatusTransition(tran);

		if (this.metricsItemsStatusDuration != null) {

			ArrayList<MetricsItemsStatusDuration> dur = new ArrayList<MetricsItemsStatusDuration>();

			for (MetricsItemsStatusDuration d : this.metricsItemsStatusDuration) {

				dur.add(new MetricsItemsStatusDuration(d));

			}
			clone.setMetricsItemsStatusDuration(dur);
		}

		if (this.metricsItemsTStatusDuration != null) {

			ArrayList<MetricsItemsTStatusDuration> tDur = new ArrayList<MetricsItemsTStatusDuration>();

			for (MetricsItemsTStatusDuration d : this.metricsItemsTStatusDuration) {

				tDur.add(new MetricsItemsTStatusDuration(d));

			}

			clone.setMetricsItemsTStatusDuration(tDur);
		}

		return clone;
	}

	public ArrayList<MetricsItemsCustomField> addCustomField(MetricsItemsCustomField field) {

		if (null == metricsItemsCustomField) {
			metricsItemsCustomField = new ArrayList<MetricsItemsCustomField>();
		}

		if (null != field) {
			if (!(field.getItemId().equals(this.getItemId()))) {
				throw new RuntimeException("FieldItemId doesnot match");
			} else {
				Boolean fieldPresent = false;
				for (MetricsItemsCustomField f : metricsItemsCustomField) {
					if (f.getFieldName().equals(field.getFieldName())) {
						fieldPresent = true;
						f.setFieldValue(field.getFieldValue());
					}
				}

				if (!fieldPresent) {
					metricsItemsCustomField.add(field);
				}
			}
		}

		return metricsItemsCustomField;
	}

	public ArrayList<MetricsItemsTStatusTransition> addTStatusTransition(MetricsItemsTStatusTransition trans) {

		if (null == metricsItemsTStatusTransition) {
			metricsItemsTStatusTransition = new ArrayList<MetricsItemsTStatusTransition>();
		}

		if (null != trans) {
			if (!(trans.getItemId().equals(this.getItemId()))) {
				throw new RuntimeException("FieldItemId doesnot match");
			} else {
				Boolean fieldPresent = false;
				for (MetricsItemsTStatusTransition t : metricsItemsTStatusTransition) {
					if (t.getStatus() == trans.getStatus()) {
						fieldPresent = true;
						t.setStatus(trans.getStatus());
					}
				}

				if (!fieldPresent) {
					metricsItemsTStatusTransition.add(trans);
				}
			}
		}

		return metricsItemsTStatusTransition;
	}

	public ArrayList<MetricsItemsStatusTransition> addStatusTransition(MetricsItemsStatusTransition sTran) {

		if (null == metricsItemsStatusTransition) {
			metricsItemsStatusTransition = new ArrayList<MetricsItemsStatusTransition>();
		}

		if (null != sTran) {
			if (!(sTran.getItemId().equals(this.getItemId()))) {
				throw new RuntimeException("FieldItemId doesnot match");
			} else {
				Boolean fieldPresent = false;
				for (MetricsItemsStatusTransition t : metricsItemsStatusTransition) {
					if ((t.getFromStatus() == sTran.getFromStatus()) && (t.getToStatus() == sTran.getToStatus())) {
						fieldPresent = true;
						t.setFromStatus(sTran.getFromStatus());
						t.setToStatus(sTran.getToStatus());
					}
				}

				if (!fieldPresent) {
					metricsItemsStatusTransition.add(sTran);
				}
			}
		}

		return metricsItemsStatusTransition;
	}

	public ArrayList<MetricsItemsStatusDuration> addStatusDuration(MetricsItemsStatusDuration dur) {

		if (null == metricsItemsStatusDuration) {
			metricsItemsStatusDuration = new ArrayList<MetricsItemsStatusDuration>();
		}

		if (null != dur) {
			if (!(dur.getItemId().equals(this.getItemId()))) {
				throw new RuntimeException("FieldItemId doesnot match");
			} else {
				Boolean fieldPresent = false;
				for (MetricsItemsStatusDuration d : metricsItemsStatusDuration) {
					if (d.getStatus() == dur.getStatus()) {
						fieldPresent = true;
						d.setStatus(dur.getStatus());
					}
				}

				if (!fieldPresent) {
					metricsItemsStatusDuration.add(dur);
				}
			}
		}

		return metricsItemsStatusDuration;
	}

	public ArrayList<MetricsItemsTStatusDuration> addTStatusDuration(MetricsItemsTStatusDuration tDur) {

		if (null == metricsItemsTStatusDuration) {
			metricsItemsTStatusDuration = new ArrayList<MetricsItemsTStatusDuration>();
		}

		if (null != tDur) {
			if (!(tDur.getItemId().equals(this.getItemId()))) {
				throw new RuntimeException("FieldItemId doesnot match");
			} else {
				Boolean fieldPresent = false;
				for (MetricsItemsTStatusDuration d : metricsItemsTStatusDuration) {
					if (d.getStatus() == tDur.getStatus()) {
						fieldPresent = true;
						d.setStatus(tDur.getStatus());
					}
				}

				if (!fieldPresent) {
					metricsItemsTStatusDuration.add(tDur);
				}
			}
		}

		return metricsItemsTStatusDuration;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MetricsItems [itemId=");
		builder.append(itemId);
		builder.append(", sourceSystemId=");
		builder.append(sourceSystemId);
		builder.append(", itemKey=");
		builder.append(itemKey);
		builder.append(", projectId=");
		builder.append(projectId);
		builder.append(", itemSummary=");
		builder.append(itemSummary);
		builder.append(", itemDescription=");
		builder.append(itemDescription);
		builder.append(", itemSummary=");
		builder.append(itemSummary);
		builder.append(", itemCreateDate=");
		builder.append(itemCreateDate);
		builder.append(", itemCreator=");
		builder.append(itemCreator);
		builder.append(", lastUpdateDate=");
		builder.append(lastUpdateDate);
		builder.append(", lastUpdateUser=");
		builder.append(lastUpdateUser);
		builder.append(", metricsItemsCustomField=");
		builder.append(metricsItemsCustomField);
		builder.append(", metricsItemsTStatusTransition=");
		builder.append(metricsItemsTStatusTransition);
		builder.append(", metricsItemsStatusTransition=");
		builder.append(metricsItemsStatusTransition);
		builder.append(", metricsItemsStatusDuration=");
		builder.append(metricsItemsStatusDuration);
		builder.append(", metricsItemsTStatusDuration=");
		builder.append(metricsItemsTStatusDuration);
		builder.append(", CheckSum=");
		builder.append(checkSum);
		builder.append("]");
		return builder.toString();
	}

	public String toStringWithoutCustomFieldsAndDates() {
		StringBuilder builder = new StringBuilder();
		builder.append("MetricsItems [itemId=");
		builder.append(itemId);
		builder.append(", sourceSystemId=");
		builder.append(sourceSystemId);
		builder.append(", itemKey=");
		builder.append(itemKey);
		builder.append(", projectId=");
		builder.append(projectId);
		builder.append(", itemSummary=");
		builder.append(itemSummary);
		builder.append(", itemDescription=");
		builder.append(itemDescription);
		builder.append(", itemSummary=");
		builder.append(itemSummary);
		builder.append(", itemCreator=");
		builder.append(itemCreator);
		builder.append(", lastUpdateUser=");
		builder.append(lastUpdateUser);
		builder.append(", CheckSum=");
		builder.append(checkSum);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkSum == null) ? 0 : checkSum.hashCode());
		result = prime * result + ((itemCreateDate == null) ? 0 : itemCreateDate.hashCode());
		result = prime * result + ((itemCreator == null) ? 0 : itemCreator.hashCode());
		result = prime * result + ((itemDescription == null) ? 0 : itemDescription.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemKey == null) ? 0 : itemKey.hashCode());
		result = prime * result + ((itemSummary == null) ? 0 : itemSummary.hashCode());
		result = prime * result + ((lastUpdateDate == null) ? 0 : lastUpdateDate.hashCode());
		result = prime * result + ((lastUpdateUser == null) ? 0 : lastUpdateUser.hashCode());
		result = prime * result + ((metricsItemsCustomField == null) ? 0 : metricsItemsCustomField.hashCode());
		result = prime * result + ((metricsItemsStatusDuration == null) ? 0 : metricsItemsStatusDuration.hashCode());
		result = prime * result
				+ ((metricsItemsStatusTransition == null) ? 0 : metricsItemsStatusTransition.hashCode());
		result = prime * result + ((metricsItemsTStatusDuration == null) ? 0 : metricsItemsTStatusDuration.hashCode());
		result = prime * result
				+ ((metricsItemsTStatusTransition == null) ? 0 : metricsItemsTStatusTransition.hashCode());
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		result = prime * result + sourceSystemId;
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
		MetricsItems other = (MetricsItems) obj;
		if (checkSum == null) {
			if (other.checkSum != null)
				return false;
		} else if (!checkSum.equals(other.checkSum))
			return false;
		if (itemCreateDate == null) {
			if (other.itemCreateDate != null)
				return false;
		} else if (!itemCreateDate.equals(other.itemCreateDate))
			return false;
		if (itemCreator == null) {
			if (other.itemCreator != null)
				return false;
		} else if (!itemCreator.equals(other.itemCreator))
			return false;
		if (itemDescription == null) {
			if (other.itemDescription != null)
				return false;
		} else if (!itemDescription.equals(other.itemDescription))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (itemKey == null) {
			if (other.itemKey != null)
				return false;
		} else if (!itemKey.equals(other.itemKey))
			return false;
		if (itemSummary == null) {
			if (other.itemSummary != null)
				return false;
		} else if (!itemSummary.equals(other.itemSummary))
			return false;
		if (lastUpdateDate == null) {
			if (other.lastUpdateDate != null)
				return false;
		} else if (!lastUpdateDate.equals(other.lastUpdateDate))
			return false;
		if (lastUpdateUser == null) {
			if (other.lastUpdateUser != null)
				return false;
		} else if (!lastUpdateUser.equals(other.lastUpdateUser))
			return false;
		if (metricsItemsCustomField == null) {
			if (other.metricsItemsCustomField != null)
				return false;
		} else if (!metricsItemsCustomField.equals(other.metricsItemsCustomField))
			return false;
		if (metricsItemsStatusDuration == null) {
			if (other.metricsItemsStatusDuration != null)
				return false;
		} else if (!metricsItemsStatusDuration.equals(other.metricsItemsStatusDuration))
			return false;
		if (metricsItemsStatusTransition == null) {
			if (other.metricsItemsStatusTransition != null)
				return false;
		} else if (!metricsItemsStatusTransition.equals(other.metricsItemsStatusTransition))
			return false;
		if (metricsItemsTStatusDuration == null) {
			if (other.metricsItemsTStatusDuration != null)
				return false;
		} else if (!metricsItemsTStatusDuration.equals(other.metricsItemsTStatusDuration))
			return false;
		if (metricsItemsTStatusTransition == null) {
			if (other.metricsItemsTStatusTransition != null)
				return false;
		} else if (!metricsItemsTStatusTransition.equals(other.metricsItemsTStatusTransition))
			return false;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		if (sourceSystemId != other.sourceSystemId)
			return false;
		return true;
	}

}
