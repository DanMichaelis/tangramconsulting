package org.csbs.labelprocessor.formatters;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.csbs.labelprocessor.domain.StringConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCSVFormatter {
	private static List<StringConfiguration> stringConfigurations = new ArrayList<StringConfiguration>();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		stringConfigurations.add(new StringConfiguration("NEXT", "Default", "Next", "iso-8859-1"));
		stringConfigurations.add(new StringConfiguration("CANCEL", "Default", "Cancel"));
		stringConfigurations.add(new StringConfiguration("FIRST_NAME", "Default", "First Name"));
		stringConfigurations.add(new StringConfiguration("LAST_NAME", "Default", "Last Name"));
		stringConfigurations.add(new StringConfiguration("ERROR_1", "Default", "This is an error message"));
		stringConfigurations.add(new StringConfiguration("ERROR_2", "Default",
				"This is an error message containing a placeholder (%s) for a formatted string"));
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testStringConfigurationsToCSV() {
		String outputCSV = "junk";
		Writer writer = CSVFormatter.stringConfigurationsToCSV(stringConfigurations);
		try {
			writer.write(outputCSV);
			System.out.println(outputCSV);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fail("Not yet implemented");
		
	}

	@Test
	void testCsvToStringConfigurations() {
		List<StringConfiguration> configsFromFile = new ArrayList<StringConfiguration>();
		configsFromFile = this.getConfigurationsFromFile("TestCSVFile.csv");
		
		this.compareConfigLists(configsFromFile, "TestCSVFile.csv", stringConfigurations, "expected values");
	}
	
	private List<StringConfiguration> getConfigurationsFromFile(String fileName) {
		List<StringConfiguration> configsFromFile = null;

		try (FileInputStream fis = new FileInputStream(this.getTestCSVFile(fileName))) {
			configsFromFile = CSVFormatter.csvToStringConfigurations(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Couldn't read file TestCSVFile.csv from src/test/resources");
		} catch (IOException e) {
			e.printStackTrace();
			fail("Couldn't read file TestCSVFile.csv from src/test/resources");
		}
		return configsFromFile;
	}
	
	private File getTestCSVFile(String testFileName) {
		return new File(Thread.currentThread().getContextClassLoader().getResource(testFileName).getFile());
	}
	
	private void compareConfigLists(List<StringConfiguration> list1,String list1SourceName, List<StringConfiguration> list2, String list2SourceName) {
		Iterator<StringConfiguration> list1Iterator = list1.iterator();
		Iterator<StringConfiguration> list2Iterator = list2.iterator();
		StringConfiguration sc;
		
		while (list1Iterator.hasNext()) {
			sc = list1Iterator.next();
			assertTrue(list2.contains(sc), "Configuration " + sc.toString() + " should not have been in " + list1SourceName + ", but was");
		}
		while (list2Iterator.hasNext()) {
			sc = list2Iterator.next();
			assertTrue(list1.contains(sc),
					"Configuration " + sc.toString() + " should have been in " + list2SourceName + ", but was not");
		}
	}

}
