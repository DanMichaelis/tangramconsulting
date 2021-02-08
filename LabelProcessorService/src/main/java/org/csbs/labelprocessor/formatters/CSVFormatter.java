package org.csbs.labelprocessor.formatters;


import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.csbs.labelprocessor.domain.StringConfiguration;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class CSVFormatter {
	
	private CSVFormatter() {
		
	}
	
	/**
	 * Converts an input stream that represents a CSV file into a list of StringConfiguration objects
	 * @param csvStream an InputStream derived from a CSV file that should contain string configurations for the front end screens
	 * @return the list of StringConfigurations that are depicted in the CSV file
	 */
	public static final List<StringConfiguration> csvToStringConfigurations(InputStream csvStream) {
		List<StringConfiguration> stringConfigurations;
		
		BufferedInputStream bis = convertInputToUSAscii(csvStream); 

		stringConfigurations = new CsvToBeanBuilder<StringConfiguration>(new InputStreamReader(bis))
				.withType(StringConfiguration.class).build().parse();

		return stringConfigurations;
	}
	
	/**
	 * Converts the data in the input stream passed in to US ASCII, anhd returns that as a buffered input stream
	 * @param is Data to be converted to US ASCII
	 * @return Data in US ASCII format
	 */
	private static BufferedInputStream convertInputToUSAscii(InputStream is) {
		StringBuilder convertedString = new StringBuilder();
		byte[] inputBytes;
		try {
			inputBytes = is.readAllBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Couldn't convert inputstream to ASCII", e);
		}
		for (byte b : inputBytes) {
			char c = (char) b;
			if (c <= 0xFF ) {
				convertedString.append(c);
			}
		}
		
		ByteArrayInputStream bais;
		try {
			bais = new ByteArrayInputStream(convertedString.toString().getBytes("ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Couldn't convert string " + convertedString.toString() + " to LATIN-1");
		}
		BufferedInputStream bis = new BufferedInputStream(bais);
		return bis;
	}
	
	/**
	 * Converts a list of StringConfigurations to CSV formatted output stream
	 * @param configs List of StringConfigurations
	 * @return BufferedOutputStream containing the configuration objects formatted as a CSV stream 
	 */
	public static final BufferedInputStream stringConfigurationsToCSV(List<StringConfiguration> configs) {
		StringWriter sw = new StringWriter();
		StatefulBeanToCsvBuilder<StringConfiguration> builder = new StatefulBeanToCsvBuilder<>(sw);
		StatefulBeanToCsv<StringConfiguration> beanWriter = builder.build();
		try {
			beanWriter.write(configs);
		} catch (CsvDataTypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Cannot convert the current list of string configs to a CSV file", e);
		} catch (CsvRequiredFieldEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Cannot convert the current list of string configs to a CSV file", e);
		}
		
		ByteArrayInputStream bais = new ByteArrayInputStream(sw.getBuffer().toString().getBytes());
		return convertInputToUSAscii(bais);
	}
}
