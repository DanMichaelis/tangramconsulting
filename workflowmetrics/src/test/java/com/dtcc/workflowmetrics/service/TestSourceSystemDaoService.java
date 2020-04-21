package com.dtcc.workflowmetrics.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

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

import com.dtcc.workflowmetrics.dao.SourceSystemDao;
import com.dtcc.workflowmetrics.entity.SourceSystem;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSourceSystemDaoService {

    @Mock
    private SourceSystemDao dao;

    @InjectMocks
    SourceSystemDaoService daoSvc = new SourceSystemDaoService();

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
        daoSvc.deleteAll();
        sourceSystems.removeAll(sourceSystems);
        sourceSystems.add(JIRA);
        sourceSystems.add(SNOW);
        sourceSystems.add(SERENA);

        when(dao.findById(JIRA.getId())).thenReturn(Optional.of(JIRA));
        when(dao.findById(SNOW.getId())).thenReturn(Optional.of(SNOW));
        when(dao.findById(SERENA.getId())).thenReturn(Optional.of(SERENA));

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSave() {
        SourceSystem newJira = daoSvc.save(JIRA);

        assertEquals(JIRA.getId(), newJira.getId());
        assertEquals(JIRA.getDescription(), newJira.getDescription());
    }

    @Test
    public void testSaveAll() {

        Iterable<SourceSystem> savedSourceSystems = daoSvc.saveAll(sourceSystems);
        compareListWithReturnList(sourceSystems, savedSourceSystems);
    }

    @Test
    public void testFindById() {
        daoSvc.saveAll(sourceSystems);
        Optional<SourceSystem> optS = daoSvc.findById(JIRA.getId().intValue());
        SourceSystem s = optS.get();
        assertEquals(JIRA, s);

        optS = daoSvc.findById(SERENA.getId().intValue());
        s = optS.get();
        assertEquals(SERENA, s);

        Boolean failed = true;
        try {
            optS = daoSvc.findById(1000);
            s = optS.get();
        } catch (NoSuchElementException e) {
         failed = false;   
        }
        assertFalse(failed);
        
    }

    @Test
    public void testExistsById() {
        daoSvc.saveAll(sourceSystems);
        assertTrue(daoSvc.existsById(JIRA.getId()));
        assertFalse(daoSvc.existsById(Integer.valueOf(-1)));
    }

    @Test
    public void testFindAll() {
        daoSvc.saveAll(sourceSystems);
        Iterable<SourceSystem> savedSourceSystems = daoSvc.findAll();

        compareListWithReturnList(sourceSystems, savedSourceSystems);

    }

    @Test
    public void testFindAllById() {
        daoSvc.saveAll(sourceSystems);

        ArrayList<Integer> ids = new ArrayList<Integer>();

        for (SourceSystem s : sourceSystems) {
            ids.add(Integer.valueOf(s.getId()));
        }

        Iterable<SourceSystem> savedSourceSystems = daoSvc.findAllById(ids);
        compareListWithReturnList(sourceSystems, savedSourceSystems);
    }

    @Test
    public void testCount() {
        daoSvc.saveAll(sourceSystems);
        assertEquals(sourceSystems.size(), daoSvc.count());
    }

    @Test
    public void testDeleteById() {
        daoSvc.saveAll(sourceSystems);
        daoSvc.deleteById(JIRA.getId());
        Iterable<SourceSystem> sss = daoSvc.findAll();
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
        daoSvc.saveAll(sourceSystems);
        daoSvc.delete(JIRA);
        Iterable<SourceSystem> rss = daoSvc.findAll();
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
        daoSvc.saveAll(sourceSystems);
        ArrayList<SourceSystem> deletableSystems = new ArrayList<SourceSystem>();

        deletableSystems.add(JIRA);
        deletableSystems.add(SNOW);

        daoSvc.deleteAll(deletableSystems);
        Iterable<SourceSystem> rss = daoSvc.findAll();
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
        daoSvc.saveAll(sourceSystems);
        daoSvc.deleteAll();
        assertEquals(0, daoSvc.count());
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
