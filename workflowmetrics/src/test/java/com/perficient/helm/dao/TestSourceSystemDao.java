package com.dtcc.workflowmetrics.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dtcc.workflowmetrics.entity.SourceSystem;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSourceSystemDao {
    
    @Autowired
    SourceSystemDao dao;
    
    private static final SourceSystem JIRA = new SourceSystem(1, "Jira");
    private static final SourceSystem SNOW = new SourceSystem(2, "SNOW");
    private static final SourceSystem SERENA = new SourceSystem(3, "SERENA");
    
    private static final ArrayList<SourceSystem> sourceSystems = new ArrayList<SourceSystem>();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        dao.deleteAll();
        sourceSystems.removeAll(sourceSystems);
        sourceSystems.add(JIRA);
        sourceSystems.add(SNOW);
        sourceSystems.add(SERENA);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSave() {
        SourceSystem newJira = dao.save(JIRA);
        
        assertEquals(JIRA.getId(), newJira.getId());
        assertEquals(JIRA.getDescription(), newJira.getDescription());
    }

    @Test
    public void testSaveAll() {
        
        Iterable<SourceSystem> savedSourceSystems = dao.saveAll(sourceSystems);
        compareListWithReturnList(sourceSystems, savedSourceSystems);
    }

    @Test
    public void testFindById() {
        dao.saveAll(sourceSystems);
        Optional<SourceSystem> optS = dao.findById(JIRA.getId().intValue());
        SourceSystem s = optS.get();
        assertEquals(JIRA, s);
    }

    @Test
    public void testExistsById() {
        dao.saveAll(sourceSystems);
        assertTrue(dao.existsById(JIRA.getId()));
        assertFalse(dao.existsById(Integer.valueOf(-1)));
    }

    @Test
    public void testFindAll() {
        dao.saveAll(sourceSystems);
        Iterable<SourceSystem> savedSourceSystems = dao.findAll();

        compareListWithReturnList(sourceSystems, savedSourceSystems);
        
    }

    @Test
    public void testFindAllById() {
        dao.saveAll(sourceSystems);
        
        ArrayList<Integer> ids = new ArrayList<Integer>();
        
        for (SourceSystem s : sourceSystems) {
            ids.add(Integer.valueOf(s.getId()));
        }
        
        Iterable<SourceSystem> savedSourceSystems = dao.findAllById(ids);
        compareListWithReturnList(sourceSystems, savedSourceSystems);
    }

    @Test
    public void testCount() {
        dao.saveAll(sourceSystems);
        assertEquals(sourceSystems.size(), dao.count());
    }

    @Test
    public void testDeleteById() {
        dao.saveAll(sourceSystems);
        dao.deleteById(JIRA.getId());
        Iterable<SourceSystem> sss = dao.findAll();
        ArrayList<SourceSystem> sssa = new ArrayList<SourceSystem>();
        sss.forEach(sssa::add);
        assertEquals(sourceSystems.size() - 1, sssa.size());
        for (SourceSystem s : sourceSystems) {
            if (s.equals(JIRA)) {
                assertFalse(sssa.contains(s));
            } else {
                assertTrue(sssa.contains(s));
            }
        }
    }

    @Test
    public void testDelete() {
        dao.saveAll(sourceSystems);
        dao.delete(JIRA);
        Iterable<SourceSystem> rss = dao.findAll();
        ArrayList<SourceSystem> rssa = new ArrayList<SourceSystem>();
        rss.forEach(rssa::add);
        
        for (SourceSystem s : sourceSystems) {
            if (s.equals(JIRA)) {
                assertFalse(rssa.contains(s));
            } else {
                assertTrue(rssa.contains(s));
            }
        }
    }

    @Test
    public void testDeleteAllIterableOfQextendsT() {
        dao.saveAll(sourceSystems);
        ArrayList<SourceSystem> deletableSystems = new ArrayList<SourceSystem>();
        
        deletableSystems.add(JIRA);
        deletableSystems.add(SNOW);
        
        dao.deleteAll(deletableSystems);
        Iterable<SourceSystem> rss = dao.findAll();
        ArrayList<SourceSystem> rssa = new ArrayList<SourceSystem>();
        rss.forEach(rssa::add);
        
        for (SourceSystem s : sourceSystems) {
            if (s.equals(JIRA) || s.equals(SNOW)) {
                assertFalse(rssa.contains(s));
            } else {
                assertTrue(rssa.contains(s));
            }
        }
    }

    @Test
    public void testDeleteAll() {
        dao.saveAll(sourceSystems);
        dao.deleteAll();
        assertEquals(0, dao.count());
    }
    
    private void compareListWithReturnList(Iterable<SourceSystem> originalList, Iterable<SourceSystem> returnedList) {
        ArrayList<SourceSystem> originalArray = new ArrayList<SourceSystem>();
        originalList.forEach(originalArray::add);
        ArrayList<SourceSystem> returnedArray = new ArrayList<SourceSystem>();
        returnedList.forEach(returnedArray::add);
        
        ArrayList<SourceSystem> inOriginalButNotInReturned = new ArrayList<SourceSystem>(originalArray);
        ArrayList<SourceSystem> inReturnedButNotInOriginal = new ArrayList<SourceSystem>(returnedArray);
        
        inOriginalButNotInReturned.removeAll(returnedArray);
        inReturnedButNotInOriginal.removeAll(originalArray);
        
        assertEquals(0, inOriginalButNotInReturned.size());
        assertEquals(0, inReturnedButNotInOriginal.size());
    }

}
