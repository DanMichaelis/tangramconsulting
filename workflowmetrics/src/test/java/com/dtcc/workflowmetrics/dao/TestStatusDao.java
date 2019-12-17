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

import com.dtcc.workflowmetrics.entity.Status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStatusDao {

    @Autowired
    StatusDao dao;

    private static Status st1 = (new Status()).setStatusId("statusId1").setSourceSystemId(12).setDescription("description1").setCheckSum("").setName("name1").setLastUpdateDate(System.currentTimeMillis());
    private static Status st2 = (new Status()).setStatusId("statusId2").setSourceSystemId(12).setDescription("description2").setCheckSum("").setName("name2").setLastUpdateDate(System.currentTimeMillis());
    private static Status st3 = (new Status()).setStatusId("statusId3").setSourceSystemId(12).setDescription("description3").setCheckSum("").setName("name3").setLastUpdateDate(System.currentTimeMillis());
    private ArrayList<Status> status = new ArrayList<Status>();
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        dao.deleteAll();
        status.removeAll(status);
        status.add(st1);
        status.add(st2);
        status.add(st3);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSave() {
        Status savedStatus = dao.save(st1);
        assertEquals(st1, savedStatus);
        System.out.println(st1.getCheckSum());
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