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
     * <p>
     * 等价类：
     * | 输入条件 | 有效等价类        | 编号   | 无效等价类               | 编号   |
     * | ---- | ------------ | ---- | ------------------- | ---- |
     * | 加数1  | 浮点数          | 1    |                     |      |
     * |      | 整数           | 2    |                     |      |
     * |      | 科学记数法(如1e-5) | 3    |  |    |
     * | 加数2  | 浮点数          | 4    |                     |      |
     * |      | 整数           | 5    |                     |      |
     * |      | 科学记数法(如1e-5) | 6    | |     |
     */
//    @Test(expected = NumberFormatException.class)
    @Test
    public void testAddForV1V2() throws Exception {
        // 1. 有效等价类测试用例9个
        Assert.assertEquals(-1.0, ArithHelper.add(1.0, -2.0), 1e-9);
        Assert.assertEquals(81.0, ArithHelper.add(-1.0, 82), 1e-9);
        Assert.assertEquals(85.7, ArithHelper.add(85.5, 2e-1), 1e-9);

        Assert.assertEquals(10.0, ArithHelper.add(12, -2.0), 1e-9);
        Assert.assertEquals(-10.5, ArithHelper.add(-11, 0.5), 1e-9);
        Assert.assertEquals(2e-5, ArithHelper.add(0, 2e-5), 1e-9);

        Assert.assertEquals((1e-5) - 2, ArithHelper.add(1e-5, -2.0), 1e-9);
        Assert.assertEquals((-5e8) + 0.5, ArithHelper.add(-5e8, 0.5), 1e-9);
        Assert.assertEquals((1e0) + (2e5), ArithHelper.add(1e0, 2e5), 1e-9);
    }

    /**
     * 要求输入2个string格式的数字
     * 等价类：
     * | 输入条件 | 有效等价类        | 编号   | 无效等价类               | 编号   |
     * | ---- | ------------ | ---- | ------------------- | ---- |
     * | 加数1  | 浮点数字符串          | 1    |  不合法的格式(如"abc"、"!@#!@d"等)   |  7    |
     * |      | 整数字符串           | 2    |                     |      |
     * |      | 科学记数法(如1e-5)字符串 | 3    | 不合法的格式(如"1e1.5"、"2ea"等) | 8    |
     * | 加数2  | 浮点数字符串          | 4    | 不合法的格式(如"1e1.5"、"2ea"等)  |   9   |
     * |      | 整数字符串           | 5    |                     |      |
     * |      | 科学记数法(如1e-5)字符串 | 6    | 不合法的格式(如"abc"、"!@#!@d"、"1e1.5"、"2ea"等) | 10   |
     *
     * @throws Exception
     */
    @Test
    public void testStringAddForV1V2() throws Exception {
        // 1. 有效等价类测试用例9个
        Assert.assertEquals(-1.0, ArithHelper.add("1.0", "-2.0"), 1e-9);
        Assert.assertEquals(81.0, ArithHelper.add("-1.0", "82"), 1e-9);
        Assert.assertEquals(85.7, ArithHelper.add("85.5", "2e-1"), 1e-9);

        Assert.assertEquals(10.0, ArithHelper.add("12", "-2.0"), 1e-9);
        Assert.assertEquals(-10.5, ArithHelper.add("-11", "0.5"), 1e-9);
        Assert.assertEquals(2e-5, ArithHelper.add("0", "2e-5"), 1e-9);

        Assert.assertEquals((1.5e-5) - 2, ArithHelper.add("1.5e-5", "-2.0"), 1e-9);
        Assert.assertEquals((-5e8) + 0.5, ArithHelper.add("-5e8", "0.5"), 1e-9);
        Assert.assertEquals((1e0) + (2e5), ArithHelper.add("1e0", "2e5"), 1e-9);

//        // 2. 无效等价类测试用例
//        Assert.assertEquals((1e0) + (2e5), ArithHelper.add("1e0", "2ea"), 1e-9);
//        Assert.assertEquals((1e0) + (2e5), ArithHelper.add("15.2", "1e1.5"), 1e-9);
//        Assert.assertEquals((1e0) + (2e5), ArithHelper.add("10", "abc"), 1e-9);
//        Assert.assertEquals((1e0) + (2e5), ArithHelper.add("-12.5", "@!#!$"), 1e-9);
//
//        Assert.assertEquals((1e0) + (2e5), ArithHelper.add( "2ea","1.5e5"), 1e-9);
//        Assert.assertEquals((1e0) + (2e5), ArithHelper.add("xczv", "3e1"), 1e-9);
//        Assert.assertEquals((1e0) + (2e5), ArithHelper.add("!@#fds.qwe", "123.5"), 1e-9);
//        Assert.assertEquals((1e0) + (2e5), ArithHelper.add("-321.dsf", "123"), 1e-9);
//
//        // 3. 两个参数均无效
//        Assert.assertEquals((1e0) + (2e5), ArithHelper.add( "2ea","1.5e3.8"), 1e-9);
//        Assert.assertEquals((1e0) + (2e5), ArithHelper.add("xczv", "3.das"), 1e-9);
//        Assert.assertEquals((1e0) + (2e5), ArithHelper.add("!@#fds.qwe", "a.5e4"), 1e-9);
//        Assert.assertEquals((1e0) + (2e5), ArithHelper.add("-321.dsf", "-abc"), 1e-9);

    }

    /**
     * Method: round(double v, int scale)
     * <p>
     * | 输入条件 | 有效等价类        | 编号   | 无效等价类               | 编号   |
     * | ---- | ------------ | ---- | ------------------- | ---- |
     * | 待处理数  | 浮点数          | 1    |     不合法的格式(如"abc"、"!@#!@d"等)                |   7   |
     * |      | 整数          | 2    |         不合法的格式(如"1e1.5"、"2ea"等)            |   8   |
     * |      | 科学记数法(如1e-5) | 3    |           |             |
     * | 加数2  | 正整数          | 4    |  负整数                   |   9   |
     * |        |           |         |  |      |
     * |      | 0           | 5    |                     |      |
     */
    @Test
    public void testStringRoundForVScale() throws Exception {
        // 1. 有效等价类用例
        Assert.assertEquals(1.23, ArithHelper.round(1.234, 2), 1e-9);
        Assert.assertEquals(-7.0, ArithHelper.round(-7.345, 0), 1e-9);

        Assert.assertEquals(1234, ArithHelper.round(1234, 5), 1e-9);
        Assert.assertEquals(7.0, ArithHelper.round(7, 0), 1e-9);

        Assert.assertEquals(-5354.323, ArithHelper.round(-5.354323e3, 3), 1e-9);
        Assert.assertEquals(15.0, ArithHelper.round(1.5e1, 0), 1e-9);


//        // 2. 无效等价类用例
//        // 2.1 参数1无效
//        Assert.assertEquals(1.23, ArithHelper.round("abc", 2), 1e-9);
//        Assert.assertEquals(-7.0, ArithHelper.round("!@#!", 0), 1e-9);
//
//        Assert.assertEquals(1234, ArithHelper.round("-2eabc.321", 5), 1e-9);
//        Assert.assertEquals(-7.0, ArithHelper.round("1e1.5", 0), 1e-9);
//
//        // 2.2 参数2无效
//        Assert.assertEquals(1234, ArithHelper.round("1234", -5), 1e-9);
//
//        // 2.3 参数1,2均无效
//        Assert.assertEquals(-5354.323, ArithHelper.round("abc", -3), 1e-9);
//        Assert.assertEquals(15.0, ArithHelper.round("1e1.5", -2), 1e-9);
    }

    /**
     * Method: round(double v, int scale)
     * <p>
     * | 输入条件 | 有效等价类        | 编号   | 无效等价类               | 编号   |
     * | ---- | ------------ | ---- | ------------------- | ---- |
     * | 待处理数  | 浮点数          | 1    |                     |      |
     * |      | 整数          | 2    |                     |      |
     * |      | 科学记数法(如1e-5) | 3    | |     |
     * | 加数2  | 正整数          | 4    |  负整数                   |   7   |
     * |        |           |         |  |      |
     * |      | 0           | 5    |                     |      |
     */
    @Test
    public void testRoundForVScale() throws Exception {
        // 1. 有效等价类用例
        Assert.assertEquals(1.23, ArithHelper.round(1.234, 2), 1e-9);
        Assert.assertEquals(-7.0, ArithHelper.round(-7.345, 0), 1e-9);

        Assert.assertEquals(1234, ArithHelper.round(1234, 8), 1e-9);
        Assert.assertEquals(7.0, ArithHelper.round(7, 0), 1e-9);

        Assert.assertEquals(-5354.323, ArithHelper.round(-5.354323e3, 3), 1e-9);
        Assert.assertEquals(15.0, ArithHelper.round(1.5e1, 0), 1e-9);


//        // 2. 无效等价类用例
//        Assert.assertEquals(1.23, ArithHelper.round(1.234, -2), 1e-9);
    }


} 
