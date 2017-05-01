/*
 * Copyright (c) 2017 Sales Rabbit, Inc. All rights reserved.
 */

package meta.samples;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Some examples on things you can do with JUnit
 *
 * Created by evan on 4/13/17.
 */
@Ignore
public class SampleUnitTest {

    ClassToTest instance;

    @Before
    public void setUp() {
        instance = new ClassToTest();
    }

    @After
    public void tearDown() {
        instance.close();
    }

    @Test
    public void usingPrebuiltInstance() throws Exception {
        // execute
        int twoPlusTwo = instance.add(2, 2);

        // verify
        assertEquals(4, twoPlusTwo);
    }

    @Test
    public void methodResults() throws Exception {
        // build
        ClassToTest tester = new ClassToTest();

        // execute
        int twoPlusTwo = tester.add(2, 2);

        // verify
        assertEquals(4, twoPlusTwo);
    }

    @Test
    public void mockingReturnValues() throws Exception {
        // build
        ClassToTest mock = mock(ClassToTest.class);
        when(mock.add(eq(2), eq(2))).thenReturn(4);

        // execute
        int twoPlusTwo = mock.add(2, 2);

        // verify
        assertEquals(4, twoPlusTwo);
    }

    private static class ClassToTest {

        public int add(int x, int y) {
            return x + y;
        }

        public void close() {
        }

    }
}
