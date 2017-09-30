package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zsf on 2017/9/30.
 */
public class CalculatorTest {
    private Calculator calculator;
    @Before
    public void setUp() throws Exception {
        calculator=new Calculator();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void add() throws Exception {
        int result = calculator.add(1, 2);
        Assert.assertEquals(result, 3);
    }

    @Test
    public void sub() throws Exception {
        int result = calculator.sub(1, 2);
        Assert.assertEquals(result, -1);
    }

}