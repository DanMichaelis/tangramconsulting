package org.csbs.configurationservice.formatters;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.StringJoiner;

import org.csbs.configurationservice.domain.StringConfiguration;


public class JSONFormatter {

	public static final BufferedInputStream stringConfigurationsToJSON(List<StringConfiguration> configs) {
		StringJoiner joiner = new StringJoiner(",", "{", "}");
		
		for (StringConfiguration sc : configs) {
			joiner.add("\"" + sc.getKey() + "\":\"" + sc.getDisplayValue() + "\"");
		}
		
		ByteArrayInputStream bais = new ByteArrayInputStream(joiner.toString().getBytes());
		BufferedInputStream bis = new BufferedInputStream(bais);
		return bis;
	}
}


