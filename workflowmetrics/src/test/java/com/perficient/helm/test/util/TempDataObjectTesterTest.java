package com.perficient.helm.test.util;

import static org.junit.Assert.*;

import java.util.function.Supplier;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TempDataObjectTesterTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testTestPassedClassesStringArray() {
        DataObjectTester dot = new DataObjectTester();

        dot.testPassedClasses(new String[] { "com.dtcc.workflowmetrics.test.util.TempClassUnderTest" });
    }

    @Test
    public void testTestPassedClassesArrayListOfString() {
        DataObjectTester dot = new DataObjectTester();

        dot.testPassedClasses(new String[] { "com.dtcc.workflowmetrics.test.util.TempClassUnderTest" });
    }

    @Test
    public void WorkingTest() {
        System.out.println (int[].class);
    }

}
