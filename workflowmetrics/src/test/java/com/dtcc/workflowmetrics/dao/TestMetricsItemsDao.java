package com.dtcc.workflowmetrics.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dtcc.workflowmetrics.entity.MetricsItems;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMetricsItemsDao {

    @Autowired
    MetricsItemsDao dao;

    private static MetricsItems mi1 = (new MetricsItems()).setItemId("Item1").setLastUpdateDate(System.currentTimeMillis()).setItemCreator("itemCreator1")
    		.setItemCreateDate(System.currentTimeMillis()).setItemSummary("itemSummary1").setCheckSum("").setItemKey("itemKey1").setLastUpdateUser("user1");
    private static MetricsItems mi2 = (new MetricsItems()).setItemId("Item2").setLastUpdateDate(System.currentTimeMillis()).setItemCreator("itemCreator2")
    		.setItemCreateDate(System.currentTimeMillis()).setItemSummary("itemSummary2").setCheckSum("").setItemKey("itemKey2").setLastUpdateUser("user2");
    private static MetricsItems mi3 = (new MetricsItems()).setItemId("Item3").setLastUpdateDate(System.currentTimeMillis()).setItemCreator("itemCreator3")
    		.setItemCreateDate(System.currentTimeMillis()).setItemSummary("itemSummary3").setCheckSum("").setItemKey("itemKey3").setLastUpdateUser("user3");
    private ArrayList<MetricsItems> metricsItems = new ArrayList<MetricsItems>();
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        dao.deleteAll();
        metricsItems.removeAll(metricsItems);
        metricsItems.add(mi1);
        metricsItems.add(mi2);
        metricsItems.add(mi3);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSave() {
    	MetricsItems savedMetricsItems = dao.save(mi1);
        assertEquals(mi1, savedMetricsItems);
        System.out.println(mi1.getCheckSum());
    }

    @Test
    public void testSaveAll() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindById() {
        fail("Not yet implemented");
    }

    @Test
    public void testExistsById() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindAll() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindAllById() {
        fail("Not yet implemented");
    }

    @Test
    public void testCount() {
        fail("Not yet implemented");
    }

    @Test
    public void testDeleteById() {
        fail("Not yet implemented");
    }

    @Test
    public void testDelete() {
        fail("Not yet implemented");
    }

    @Test
    public void testDeleteAllIterableOfQextendsT() {
        fail("Not yet implemented");
    }

    @Test
    public void testDeleteAll() {
        fail("Not yet implemented");
    }

}