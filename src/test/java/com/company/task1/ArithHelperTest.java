package com.company.task1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * ArithHelper Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>10/23/2017</pre>
 */
public class ArithHelperTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: add(double v1, double v2)
     */
    @Test(expected = NumberFormatException.class)
    public void testAddForV1V2() throws Exception {
        Assert.assertEquals(1.0,ArithHelper.add(1,0),1e-9);
        ArithHelper.add("aaa","123");
//        Assert.(ArithHelper.add("1.0","c"));
//TODO: Test goes here... 
    }

    /**
     * Method: sub(double v1, double v2)
     */
    @Test
    public void testSubForV1V2() throws Exception {
//TODO: Test goes here...
        Assert.assertEquals(1.0,ArithHelper.sub(2,1),1e-9);
    }

    /**
     * Method: mul(double v1, double v2)
     */
    @Test
    public void testMulForV1V2() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: div(double v1, double v2)
     */
    @Test
    public void testDivForV1V2() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: div(double v1, double v2, int scale)
     */
    @Test
    public void testDivForV1V2Scale() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: round(double v, int scale)
     */
    @Test
    public void testRoundForVScale() throws Exception {
//TODO: Test goes here... 
    }


} 
