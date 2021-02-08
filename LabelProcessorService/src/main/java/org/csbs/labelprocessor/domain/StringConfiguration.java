package org.csbs.labelprocessor.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByName;

@Entity
@Table(name = "EXTERNALIZED_STRINGS")
public class StringConfiguration implements Serializable {

	private static final long serialVersionUID = -4731213277494523632L;

	@Column(name = "STRING_KEY")
	@CsvBindByName(column = "Key")
	private String key;
	@Column(name = "DISPLAY_GROUP")
	@CsvBindByName(column = "Group")
	private String group;
	@Column(name = "DISPLAY_VALUE")
	@CsvBindByName(column = "Display")
	private String displayValue;
	@Column(name = "LANGUAGE")
	@CsvBindByName(column = "Language")
	private String characterSet;

	public StringConfiguration() {
	}

	public StringConfiguration(String key, String group, String displayValue, String characterSet) {
		this.key = key;
		this.group = group;
		this.displayValue = displayValue;
		this.characterSet = characterSet;
	}

	public StringConfiguration(String key, String group, String displayValue) {
		this(key, group, displayValue, null);
	}

	public String getKey() {
		if (null == key || key.isBlank()) {
			return null;
		}
		return key;
	}

	public StringConfiguration setKey(String key) {
		this.key = key;
		return this;
	}

	public String getGroup() {
		if (null == group || group.isBlank()) { 
			return null;
		}
		return group;
	}

	public StringConfiguration setGroup(String group) {
		this.group = group;
		return this;
	}

	public String getDisplayValue() {
		if (null == displayValue || displayValue.isBlank()) {
			return null;
		}
		return displayValue;
	}

	public StringConfiguration setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
		return this;
	}

	public String getCharacterSet() {
		if (null == characterSet || characterSet.isBlank()) {
			return null;
		}
		return characterSet;
	}

	public StringConfiguration setCharacterSet(String characterSet) {
		this.characterSet = characterSet;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((characterSet == null) ? 0 : characterSet.hashCode());
		result = prime * result + ((displayValue == null) ? 0 : displayValue.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		StringConfiguration other = (StringConfiguration) obj;
		if (getCharacterSet() == null) {
			if (other.getCharacterSet() != null)
				return false;
		} else if (!characterSet.equals(other.characterSet))
			return false;
		if (getDisplayValue() == null) {
			if (other.getDisplayValue() != null)
				return false;
		} else if (!displayValue.equals(other.displayValue))
			return false;
		if (getGroup() == null) {
			if (other.getGroup() != null)
				return false;
		} else if (!group.equals(other.group))
			return false;

		if (getKey() == null) {
			if (other.getKey() != null)
				return false;
		} else if (!key.equals(other.key)) {
			System.out.println("Key:  " + key + "  Other:  " + other);
			System.out.println("key length:  " + getKey().length());
			System.out.println("other length: " + other.getKey().length());
			for (int index = 0; index < key.length(); index++) {
				if (key.charAt(index) == other.key.charAt(index)) {
					System.out.print(key.charAt(index));
				} else {
					System.out.println("Character " + (int) key.charAt(index) + " is a mismatch");
				}
			}
			System.out.println();

			System.out.println("This :" + key + ":");
			System.out.println("Other :" + other.key + ":");
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "StringConfiguration [key=" + key + ", group=" + group + ", displayValue=" + displayValue
				+ ", characterSet=" + characterSet + "]";
	}

}
