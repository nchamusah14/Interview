package com.dmp.interview.quiz.utils;

/**
 * @author Norman Chamusah
 * @since 8/21/2014 1:33 PM
 */
public class QuizUtils {
    /**
     * Convert the given character array into an int value, if possible.
     *
     * It is assumed that the given character array is representative of a C-style string, i.e., that
     * it is terminated with the null character 0x0.
     *
     * @param stringInput a C-style character array representing a long value.
     * @return the corresponding long value of the given input. If the given input is not terminated by the null
     * character, return {@code Integer.MIN_VALUE}. If the given input does not represent a long value, return -1.
     */
    public static int convertToInt(char[] stringInput) {
        if (stringInput[stringInput.length - 1] != '\0') {
            return 0;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    /**
     * Tests the bit at {@code position} of the given {@code value}.
     *
     * It is assumed that the least significant bit is located at bit position 0.
     * NOTE: You are not allowed to use any String functions.
     *
     * @param value the interrogated value
     * @param position the bit-position of the given value
     * @return true if the bit at the requested position is set (i.e., is value 1), false otherwise.
     */
    public static boolean testBit(int value, int position) {
        return false;
    }
}
