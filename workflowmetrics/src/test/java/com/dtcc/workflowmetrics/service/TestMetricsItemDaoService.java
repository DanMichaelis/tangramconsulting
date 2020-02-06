package com.dtcc.workflowmetrics.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dtcc.workflowmetrics.dao.MetricsItemsDao;
import com.dtcc.workflowmetrics.entity.MetricsItems;
import com.dtcc.workflowmetrics.entity.MetricsItemsCustomField;
import com.dtcc.workflowmetrics.entity.MetricsItemsStatusDuration;
import com.dtcc.workflowmetrics.entity.MetricsItemsStatusTransition;
import com.dtcc.workflowmetrics.entity.MetricsItemsTStatusDuration;
import com.dtcc.workflowmetrics.entity.MetricsItemsTStatusTransition;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMetricsItemDaoService {

	@Mock
	private MetricsItemsDao dao;

	@InjectMocks
	MetricsItemsDaoService daoSvc = new MetricsItemsDaoService();

	static long dt = System.currentTimeMillis();

	private static final MetricsItemsCustomField cust1 = new MetricsItemsCustomField("1", 1, dt, "customfield_10101",
			"String", "1|hzyuen:");
	private static final MetricsItemsCustomField cust2 = new MetricsItemsCustomField("2", 1, dt, "customfield_18904",
			"String", null);

	private static final ArrayList<MetricsItemsCustomField> customFields = new ArrayList<MetricsItemsCustomField>();

	private static final MetricsItemsStatusTransition mist1 = new MetricsItemsStatusTransition("1", "JIRA1", 1, "new",
			"groomed", dt);
	private static final MetricsItemsStatusTransition mist2 = new MetricsItemsStatusTransition("2", "JIRA1", 1,
			"groomed", "ready for development", dt);

	private static final ArrayList<MetricsItemsStatusTransition> statusTransitions = new ArrayList<MetricsItemsStatusTransition>();

	private static final MetricsItemsStatusDuration misd1 = new MetricsItemsStatusDuration("1", "JIRA1", 1, "new",
			Long.valueOf("2"));
	private static final MetricsItemsStatusDuration misd2 = new MetricsItemsStatusDuration("1", "JIRA1", 1, "new",
			Long.valueOf("2"));

	private static final ArrayList<MetricsItemsStatusDuration> statusDurations = new ArrayList<MetricsItemsStatusDuration>();

	private static final MetricsItemsTStatusTransition mitst1 = new MetricsItemsTStatusTransition("1", "JIRA1", 1, 0,
			dt);
	private static final MetricsItemsTStatusTransition mitst2 = new MetricsItemsTStatusTransition("2", "JIRA1", 1, 1,
			dt);

	private static final ArrayList<MetricsItemsTStatusTransition> tStatusTransitions = new ArrayList<MetricsItemsTStatusTransition>();

	private static final MetricsItemsTStatusDuration mitsd1 = new MetricsItemsTStatusDuration("1", "JIRA1", 1, 0,
			Long.valueOf("2"));
	private static final MetricsItemsTStatusDuration mitsd2 = new MetricsItemsTStatusDuration("1", "JIRA1", 1, 1,
			Long.valueOf("3"));

	private static final ArrayList<MetricsItemsTStatusDuration> tStatusDurations = new ArrayList<MetricsItemsTStatusDuration>();

	private static MetricsItems item1;
	 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//daoSvc.deleteAll();

		customFields.removeAll(customFields);
		customFields.add(cust1);
		customFields.add(cust2);

		statusTransitions.removeAll(statusTransitions);
		statusTransitions.add(mist1);
		statusTransitions.add(mist2);

		statusDurations.removeAll(statusDurations);
		statusDurations.add(misd1);
		statusDurations.add(misd2);

		tStatusTransitions.removeAll(tStatusTransitions);
		tStatusTransitions.add(mitst1);
		tStatusTransitions.add(mitst2);

		tStatusDurations.removeAll(tStatusDurations);
		tStatusDurations.add(mitsd1);
		tStatusDurations.add(mitsd2);

		item1 = new MetricsItems("1", 1, "item1", "JIRA1", "MetricsItemTest1", "MetricsItemTest1",
				dt, "Tester1", dt, "Tester1", customFields, tStatusTransitions, statusTransitions, statusDurations,
				tStatusDurations);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		MetricsItems newItem = daoSvc.save(item1);

		assertEquals(item1.getItemId(), newItem.getItemId());
		assertEquals(item1.getItemKey(), newItem.getItemKey());
	}


}
