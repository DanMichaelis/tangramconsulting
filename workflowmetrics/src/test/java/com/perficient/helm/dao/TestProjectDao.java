package com.perficient.helm.dao;

import static org.junit.Assert.*;

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

import com.perficient.helm.dao.ProjectDao;
import com.perficient.helm.entity.Project;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProjectDao {

    @Autowired
    ProjectDao dao;

    private static Project CM = (new Project()).setId("CM").setKey("CM").setLast_update_date(System.currentTimeMillis())
            .setName("Company Management").setSourceSystemId(1).setChecksum("");
    private static Project METRICS = (new Project()).setId("METRICS").setKey("METRICS").setLast_update_date(System.currentTimeMillis())
            .setName("Metrics KPIs and Displays").setSourceSystemId(1).setChecksum("");
    private static Project DEVELOPMENT = (new Project()).setId("DEVELOPMENT").setKey("DEVELOPMENT").setLast_update_date(System.currentTimeMillis())
            .setName("Software Application Development").setSourceSystemId(1).setChecksum("");
    private ArrayList<Project> projects = new ArrayList<Project>();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        dao.deleteAll();
        projects.removeAll(projects);
        projects.add(CM);
        projects.add(METRICS);
        projects.add(DEVELOPMENT);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSave() {
        Project savedProject = dao.save(CM);
        assertEquals(CM, savedProject);
        System.out.println(CM.getChecksum());
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