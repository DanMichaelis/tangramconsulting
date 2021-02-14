package org.csbs.labelprocessor.formatters;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.csbs.labelprocessor.domain.StringConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestJSONFormatter {
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
	void testOjbectsToJSON() {
		System.out.println(JSONFormatter.stringConfigurationsToJSON(stringConfigurations));
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
