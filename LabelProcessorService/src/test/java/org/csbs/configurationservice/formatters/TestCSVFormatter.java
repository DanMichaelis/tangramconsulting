package org.csbs.configurationservice.formatters;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.UUID;

import org.csbs.configurationservice.domain.StringConfiguration;
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
		BufferedInputStream bis = CSVFormatter.stringConfigurationsToCSV(stringConfigurations);
		byte[] bytes = new byte[0];
		try {
			bytes = bis.readAllBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Couldn't read input bytes");
		}
		UUID uuid = UUID.randomUUID();
		String tempFileName = System.getProperty("java.io.tmpdir") + "/" + uuid.toString() + ".csv";
		File tempFile = new File(tempFileName);
		try (FileWriter fw = new FileWriter(tempFile)) {
			System.out.println("Configs:  " + new String(bytes, StandardCharsets.US_ASCII));
			fw.write(new String(bytes, StandardCharsets.US_ASCII));
			fw.flush();
			List<StringConfiguration> configs = getConfigurationsFromFile(tempFile.getAbsolutePath());
			compareConfigLists(stringConfigurations, "Test configuration List", configs,
					"String configurations read from written file");

		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			tempFile.delete();
		}
	}

	@Test
	void testCsvToStringConfigurations() {
		List<StringConfiguration> configsFromFile = new ArrayList<StringConfiguration>();
		for (String relativeFileName : new String[] { "CSVFiles/TestCSVFile-CommaDelimited.csv",
				"CSVFiles/TestCSVFileDOS.csv", "CSVFiles/TestCSVFile-Macintosh.csv",
				"CSVFiles/TestCSVFile-UTF8.csv" }) {
			System.out.println("Reading file " + relativeFileName);
			String absoluteFileName = Thread.currentThread().getContextClassLoader().getResource(relativeFileName).getPath();
			configsFromFile = this.getConfigurationsFromFile(absoluteFileName);

			this.compareConfigLists(configsFromFile, relativeFileName, stringConfigurations, "expected values");
		}
	}

	private List<StringConfiguration> getConfigurationsFromFile(String absolutePathToFile) {
		List<StringConfiguration> configsFromFile = null;

		try (FileInputStream fis = new FileInputStream(absolutePathToFile)) {
			configsFromFile = CSVFormatter.csvToStringConfigurations(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//fail("Couldn't read file from src/test/resources");

		} catch (IOException e) {
			e.printStackTrace();
			fail("Couldn't read file TestCSVFile.csv from src/test/resources");
		}
		return configsFromFile;
	}

	private void compareConfigLists(List<StringConfiguration> list1, String list1SourceName,
			List<StringConfiguration> list2, String list2SourceName) {
		Iterator<StringConfiguration> list1Iterator = list1.iterator();
		Iterator<StringConfiguration> list2Iterator = list2.iterator();
		StringConfiguration sc;

		while (list1Iterator.hasNext()) {
			sc = list1Iterator.next();
			assertTrue(list2.contains(sc),
					"Configuration " + sc.toString() + " should not have been in " + list1SourceName + ", but was");
		}
		while (list2Iterator.hasNext()) {
			sc = list2Iterator.next();
			assertTrue(list1.contains(sc),
					"Configuration " + sc.toString() + " should have been in " + list2SourceName + ", but was not");
		}
	}

}
