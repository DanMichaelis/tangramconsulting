package org.csbs.labelprocessor.formatters;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import org.csbs.labelprocessor.domain.StringConfiguration;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class CSVFormatter {

	public static final List<StringConfiguration> csvToStringConfigurations(InputStream csvStream) {
		List<StringConfiguration> stringConfigurations;

		stringConfigurations = new CsvToBeanBuilder<StringConfiguration>(new InputStreamReader(csvStream))
				.withType(StringConfiguration.class).build().parse();

		return stringConfigurations;
	}

	public static final Writer stringConfigurationsToCSV(List<StringConfiguration> configs) {
		StringWriter sw = new StringWriter();
		StatefulBeanToCsvBuilder<StringConfiguration> builder = new StatefulBeanToCsvBuilder<>(sw);
		StatefulBeanToCsv<StringConfiguration> beanWriter = builder.build();
		try {
			beanWriter.write(configs);
		} catch (CsvDataTypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sw.toString());
		return null;
		
		/*
		 * OutputStreamWriter writer = new OutputStreamWriter(new
		 * ByteArrayOutputStream()); StatefulBeanToCsvBuilder<StringConfiguration>
		 * builder = new StatefulBeanToCsvBuilder<StringConfiguration>(writer);
		 * StatefulBeanToCsv<StringConfiguration> converter = builder.build(); try {
		 * converter.write(configs); } catch (CsvDataTypeMismatchException e) {
		 * e.printStackTrace(); throw new
		 * RuntimeException("Couldn't process the list of string configurations", e); }
		 * catch (CsvRequiredFieldEmptyException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); throw new
		 * RuntimeException("One or more of the string configurations is missing a required value"
		 * , e); } return writer;
		 */
	}
}
