package org.csbs.labelprocessor.formatters;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.StringJoiner;

import org.csbs.labelprocessor.domain.StringConfiguration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONFormatter {

	public static final BufferedInputStream stringConfigurationsToJSON(List<StringConfiguration> configs) {
		JSONFormatter.configuration configuration = new JSONFormatter.configuration(configs);
		StringJoiner joiner = new StringJoiner(",", "{", "}");
		
		for (StringConfiguration sc : configs) {
			joiner.add("\"" + sc.getKey() + "\":\"" + sc.getDisplayValue() + "\"");
		}
		
		ByteArrayInputStream bais = new ByteArrayInputStream(joiner.toString().getBytes());
		BufferedInputStream bis = new BufferedInputStream(bais);
		return bis;
	}
	
	private static class configuration {
		private List<StringConfiguration> configs;
		
		configuration(List<StringConfiguration> configs) {
			this.configs = configs;
		}
		
		public List<StringConfiguration> getConfigs() {
			return configs;
		}
	}
	
	
}


