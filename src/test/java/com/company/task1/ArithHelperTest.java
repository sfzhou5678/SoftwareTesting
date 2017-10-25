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
     * | 加数1  | 浮点数字符串          | 1    |     |     |
     * |      | 整数字符串           | 2    |                     |      |
     * |      | 科学记数法(如1e-5)字符串 | 3    | 不合法的格式(如"abc"、"!@#!@d"、"1e1.5"、"2ea"等) | 7    |
     * | 加数2  | 浮点数字符串          | 4    | 不合法的格式(如"abc"、"!@#!@d"、"1e1.5"、"2ea"等)  |   8   |
     * |      | 整数字符串           | 5    |                     |      |
     * |      | 科学记数法(如1e-5)字符串 | 6    |  |    |
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
    }

    @Test(expected = NumberFormatException.class)
    public void testStringAddFovV1V2Exception() throws Exception {
        // 2. 无效等价类测试用例
        ArithHelper.add("15.2", "!@#SF.asd");   // 1,8
        ArithHelper.add("10", "aacc");     // 2,8
        ArithHelper.add("1e5", "!@#SDf");    // 3,8


        ArithHelper.add("xczv", "1.5e5");   // 7,4
        ArithHelper.add("!@#fds.qwe", "abc");    // 7,5
        ArithHelper.add("!@#fds.qwe", "1e0");   // 7,6

        ArithHelper.add("xczv", "3e1.5");   // 7,8
    }

    /**
     * Method: div(String v1, String v2)
     * /**
     * 要求输入2个string格式的数字
     * 等价类：
     * | 输入条件 | 有效等价类        | 编号   | 无效等价类               | 编号   |
     * | ---- | ------------ | ---- | ------------------- | ---- |
     * | 加数1  | 浮点数字符串          | 1    |        |      |
     * |      | 非零整数字符串           | 2    |      零      |  7  |
     * |      | 科学记数法(如1e-5)字符串 | 3    | 不合法的格式(如"1e1.5"、"2ea"、"abc"、"!@#!@d等) | 8    |
     * | 加数2  | 浮点数字符串          | 4    |         |      |
     * |      | 非零整数字符串           | 5    |        零        |   9 |
     * |      | 科学记数法(如1e-5)字符串 | 6    | 不合法的格式(如"1e1.5"、"2ea"、"abc"、"!@#!@d等) | 10   |
     *
     * @throws Exception
     */
    @Test
    public void testStringDivForV1V2() throws Exception {
        // 1. 有效等价类测试用例9个
        Assert.assertEquals(-0.5, ArithHelper.div("1.0", "-2.0"), 1e-9);
        Assert.assertEquals(-1 / 5.0, ArithHelper.div("-1.0", "5"), 1e-9);
        Assert.assertEquals(85.5 / 2e-1, ArithHelper.div("85.5", "2e-1"), 1e-9);

        Assert.assertEquals(-12 / 2, ArithHelper.div("12", "-2.0"), 1e-9);
        Assert.assertEquals(-22, ArithHelper.div("-11", "0.5"), 1e-9);
        Assert.assertEquals(0, ArithHelper.div("0", "2e-5"), 1e-9);

        Assert.assertEquals((1.5e-5) / -2, ArithHelper.div("1.5e-5", "-2.0"), 1e-9);
        Assert.assertEquals((-5e8) / 0.5, ArithHelper.div("-5e8", "0.5"), 1e-9);
        Assert.assertEquals((1e0) / (2e5), ArithHelper.div("1e0", "2e5"), 1e-9);
    }

    @Test(expected = ArithmeticException.class)
    public void testStringDivForV1V2Exception() throws Exception {
        // 2. 无效等价类测试用例
        ArithHelper.div("1.5", "0");  // 1,9
        ArithHelper.div("-2.3", "2ea");  // 1,10
        ArithHelper.div("3", "0");  // 2,9
        ArithHelper.div("-19", "2ea@!#");  // 2,10
        ArithHelper.div("1e5", "0");  // 3,9
        ArithHelper.div("-1.5e-3", "basd");  // 3,10

        ArithHelper.div("0", "1e-5");  // 7,4
        ArithHelper.div("qwers", "-3.5e-8");  // 8,4
        ArithHelper.div("0", "1.5e-3");  // 7,5
        ArithHelper.div("1e1.45", "-2.5e-8");  // 8,5
        ArithHelper.div("0", "1e-5");  // 7,6
        ArithHelper.div("@#!@#", "-8.5e-8");  // 8,6


        ArithHelper.div("0", "0");  // 7,9
        ArithHelper.div("0", "-8.5e-8.5");  // 7,10
        ArithHelper.div("asdf", "0");  // 8,9
        ArithHelper.div("as@!#", "-8.5e-8.5");  // 8,10

    }

    /**
     * Method: div(double v1, double v2)
     * | 输入条件 | 有效等价类        | 编号   | 无效等价类               | 编号   |
     * | ---- | ------------ | ---- | ------------------- | ---- |
     * | 加数1  | 浮点数          | 1    |                     |      |
     * |      | 整数           | 2    |                     |      |
     * |      | 科学记数法(如1e-5) | 3    |  |    |
     * | 加数2  | 浮点数          | 4    |                     |      |
     * |      | 整数           | 5    |                     |      |
     * |      | 科学记数法(如1e-5) | 6    | |     |
     */
    @Test
    public void testDivForV1V2() throws Exception {
        // TODO: 2017/10/25 打桩？？
        Assert.assertEquals(-0.5, ArithHelper.div(1.0, -2.0), 1e-9);
        Assert.assertEquals(-1 / 5.0, ArithHelper.div(-1.0, 5), 1e-9);
        Assert.assertEquals(85.5 / 2e-1, ArithHelper.div(85.5, 2e-1), 1e-9);

        Assert.assertEquals(-12 / 2, ArithHelper.div(12, -2.0), 1e-9);
        Assert.assertEquals(-22, ArithHelper.div(-11, 0.5), 1e-9);
        Assert.assertEquals(0, ArithHelper.div(0, 2e-5), 1e-9);

        Assert.assertEquals((1.5e-5) / -2, ArithHelper.div(1.5e-5, -2.0), 1e-9);
        Assert.assertEquals((-5e8) / 0.5, ArithHelper.div(-5e8, 0.5), 1e-9);
        Assert.assertEquals((1e0) / (2e5), ArithHelper.div(1e0, 2e5), 1e-9);
    }

    /**
     * Method: div(double v1, double v2, int scale)
     * | 输入条件 | 有效等价类        | 编号   | 无效等价类               | 编号   |
     * | ---- | ------------ | ---- | ------------------- | ---- |
     * | 加数1  | 浮点数          | 1    |                     |      |
     * |      | 整数           | 2    |                     |      |
     * |      | 科学记数法(如1e-5) | 3    |  |    |
     * | 加数2  | 浮点数          | 4    |                     |      |
     * |      | 整数           | 5    |                     |      |
     * |      | 科学记数法(如1e-5) | 6    | |     |
     * | 保留到小数点以后几位| 正整数|   7   |   负数 | 9  |
     * |   0   |8 |
     */
    @Test
    public void testDivForV1V2Scale() throws Exception {
        // 1. 有效等价类测试用例9个
        Assert.assertEquals(-0.5, ArithHelper.div(1.0, -2.0, 2), 1e-9);
        Assert.assertEquals(-1 / 5.0, ArithHelper.div(-1.0, 5, 3), 1e-9);
        Assert.assertEquals(85.5 / 2e-1, ArithHelper.div(85.5, 2e-1, 4), 1e-9);

        Assert.assertEquals(-12 / 2, ArithHelper.div(12, -2.0, 1), 1e-9);
        Assert.assertEquals(-5.5, ArithHelper.div(-11, 2, 5), 1e-9);
        Assert.assertEquals(0, ArithHelper.div(0, 2e-5, 1), 1e-9);

        Assert.assertEquals((-5e8) / 0.5, ArithHelper.div(-5e8, 0.5, 8), 1e-9);
        Assert.assertEquals((1.5e-5) / -2.0, ArithHelper.div(1.5e-5, -2, 16), 1e-9);
        // 检测出bug的用例：
//        Assert.assertEquals((1e0) / (2e5), ArithHelper.div(1e0, 2e5,5), 1e-9);

        // round=0
        Assert.assertEquals(-1.0, ArithHelper.div(1.0, -2.0, 0), 1e-9);
        Assert.assertEquals(0, ArithHelper.div(-1.0, 5, 0), 1e-9);
        Assert.assertEquals(428.0, ArithHelper.div(85.5, 2e-1, 0), 1e-9);

        Assert.assertEquals(-12 / 2, ArithHelper.div(12, -2.0, 0), 1e-9);
        Assert.assertEquals(-22, ArithHelper.div(-11, 0.5, 0), 1e-9);
        Assert.assertEquals(0, ArithHelper.div(0, 2e-5, 0), 1e-9);

        Assert.assertEquals(0, ArithHelper.div(1.5e-5, -2.0, 0), 1e-9);
        Assert.assertEquals(0, ArithHelper.div(1e0, 2e5, 0), 1e-9);
        Assert.assertEquals((-5e8) / 0.5, ArithHelper.div(-5e8, 0.5, 0), 1e-9);

        // 2. pairwise
        Assert.assertEquals(-0.5, ArithHelper.div(1.0, -2.0, 2), 1e-9); // 1,4,7
        Assert.assertEquals(-12 / 2, ArithHelper.div(12, -2.0, 0), 1e-9);   // 2,4,8
        Assert.assertEquals(-2.2, ArithHelper.div(-11, 5, 5), 1e-9); // 2,5,7
        Assert.assertEquals(0.0, ArithHelper.div(1.5e-5, -2, 0), 1e-9);// 3,5,8
        Assert.assertEquals(1.5E-7, ArithHelper.div(1.5e-5, 1e2, 8), 1e-9);// 3,6,7
        Assert.assertEquals(0, ArithHelper.div(1.5, 1e2, 0), 1e-9);// 1,6,8
        Assert.assertEquals(19.1, ArithHelper.div(38.2, 2, 3), 1e-9);// 1,5,7
        Assert.assertEquals(1, ArithHelper.div(100, 1e2, 0), 1e-9);// 2,6,8
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivForV1V2ScaleException() throws Exception {
        ArithHelper.div(1.0, -2.0, -2);
        ArithHelper.div(-1.0, 5, -3);
        ArithHelper.div(85.5, 2e-1, -4);

        ArithHelper.div(12, -2.0, -1);
        ArithHelper.div(-11, 0.5, -5);
        ArithHelper.div(0, 2e-5, -1);

        ArithHelper.div(-5e8, 0.5, -8);
        ArithHelper.div(1.5e-5, -2.0, -16);
        ArithHelper.div(1e0, 2e5, -5);
    }


    /**
     * Method: round(double v, int scale)
     * <p>
     * | 输入条件 | 有效等价类        | 编号   | 无效等价类               | 编号   |
     * | ---- | ------------ | ---- | ------------------- | ---- |
     * | 待处理数  | 浮点数          | 1    |     不合法的格式(如"abc"、"!@#!@d"、"1e1.5"、"2ea"等)                |   7   |
     * |      | 整数          | 2    |                 |      |
     * |      | 科学记数法(如1e-5) | 3    |           |             |
     * | 小数点后位数  | 正整数          | 4    |  负整数                   |   8   |
     * |        |           |         |  |      |
     * |      | 0           | 5    |                     |      |
     */
    @Test
    public void testStringRoundForVScale() throws Exception {
        // 1. 有效等价类用例
        Assert.assertEquals(1.23, ArithHelper.round("1.234", 2), 1e-9);
        Assert.assertEquals(-7.0, ArithHelper.round("-7.345", 0), 1e-9);

        Assert.assertEquals(1234, ArithHelper.round("1234", 5), 1e-9);
        Assert.assertEquals(7.0, ArithHelper.round("7", 0), 1e-9);

        Assert.assertEquals(-5354.323, ArithHelper.round("-5.354323e3", 3), 1e-9);
        Assert.assertEquals(15.0, ArithHelper.round("1.5e1", 0), 1e-9);
    }

    @Test(expected = NumberFormatException.class)
    public void testStringRoundForVScaleException() throws Exception {
        // 2. 无效等价类用例
        ArithHelper.round("asdfsdf", 3);   // 7,4
        ArithHelper.round("1.e-1.5", 0);    // 7,5
        ArithHelper.round("!@#SDF", -5);    // 7,8
        ArithHelper.round("asdfas", -3);   // 4,8

//        ArithHelper.round("asdfsdf", 3);   // 7,4
//        ArithHelper.round("1.e-1.5", 0);    // 7,5
//        ArithHelper.round("!@#SDF", -5);    // 7,8
//
//        ArithHelper.round("12.34", -5); // 1,8
//        ArithHelper.round("1234", -5);  // 2,8
//        ArithHelper.round("1e2", -3);   // 3,8
//        ArithHelper.round("asdfas", -3);   // 4,8
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringRoundForVScaleException2() throws Exception {
        // 2. 无效等价类用例
        ArithHelper.round("12.34", -5); // 1,8
        ArithHelper.round("1234", -5);  // 2,8
        ArithHelper.round("1e2", -3);   // 3,8
    }

    /**
     * Method: round(double v, int scale)
     * <p>
     * | 输入条件 | 有效等价类        | 编号   | 无效等价类               | 编号   |
     * | ---- | ------------ | ---- | ------------------- | ---- |
     * | 待处理数  | 浮点数          | 1    |                     |      |
     * |      | 整数          | 2    |                     |      |
     * |      | 科学记数法(如1e-5) | 3    | |     |
     * | 保留到小数点以后几位  | 正整数          | 4    |  负整数                   |   7   |
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
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRoundForVScaleException() throws Exception {
        ArithHelper.round(1.234, -2);
        ArithHelper.round(123, -3);
        ArithHelper.round(1e-5, -4);
    }


} 
