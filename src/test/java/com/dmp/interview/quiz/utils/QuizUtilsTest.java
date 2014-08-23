package com.dmp.interview.quiz.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuizUtilsTest {

    private static char[] number1ToConvert;
    private static char[] number2ToConvert;
    private static char[] number3ToConvert;
    private static char[] number4ToConvert;
    private static char[] number5ToConvert;

    private static int expectedInteger;
    private static int actualInteger;

    private static boolean expectedBoolean;
    private static boolean actualBoolean;

    @Before
    public void setUp() throws Exception {
        number1ToConvert = "1234".toCharArray();
        number2ToConvert = "1234".concat("\0").toCharArray();
        number3ToConvert = " 1".concat("\0").toCharArray();
        number4ToConvert = "ABCD".toCharArray();
        number5ToConvert = "ABCD".concat("\0").toCharArray();
    }

    @After
    public void tearDown() throws Exception {
        number1ToConvert = null;
        number2ToConvert = null;
        number3ToConvert = null;
    }

    @Test
    public void testConvertToInt() throws Exception {
        // number1ToConvert doesn't have null terminating character, so we expect Integer.MIN_VALUE
        expectedInteger = Integer.MIN_VALUE;
        actualInteger = QuizUtils.convertToInt(number1ToConvert);
        assertEquals(expectedInteger, actualInteger);

        // number2ToConvert is a valid number
        expectedInteger = 1234;
        actualInteger = QuizUtils.convertToInt(number2ToConvert);
        assertEquals(expectedInteger, actualInteger);

        // number3ToConvert is a valid number
        expectedInteger = 1;
        actualInteger = QuizUtils.convertToInt(number3ToConvert);
        assertEquals(expectedInteger, actualInteger);

        // number4ToConvert doesn't have null terminating character, so we expect Integer.MIN_VALUE
        expectedInteger = Integer.MIN_VALUE;
        actualInteger = QuizUtils.convertToInt(number4ToConvert);
        assertEquals(expectedInteger, actualInteger);

        // number5ToConvert while a valid hexadecimal value, isn't a valid decimal value
        expectedInteger = -1;
        actualInteger = QuizUtils.convertToInt(number5ToConvert);
        assertEquals(expectedInteger, actualInteger);
    }

    @Test
    public void testTestBit() throws Exception {
        for (int value = Short.MIN_VALUE; value < Short.MAX_VALUE; value += 1) {
            for (int position = 0; position < 32; position += 1) {
                String binaryRepresentation = new StringBuilder(padLeft(Integer.toBinaryString(value))).reverse().toString();
                expectedBoolean = (binaryRepresentation.charAt(position) == '1');
                actualBoolean = QuizUtils.testBit(value, position);
                assertEquals(expectedBoolean, actualBoolean);
            }
        }

        System.out.println(padLeft(Integer.toBinaryString(Short.MAX_VALUE)));
    }

    private String padLeft(String number) {
        return String.format("%32s", number).replace(' ', '0');
    }
}