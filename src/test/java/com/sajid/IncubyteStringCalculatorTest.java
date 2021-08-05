package com.sajid;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class IncubyteStringCalculatorTest {
    @Test
    public void add_emptyNumbers_success() throws Exception {
        assertEquals(0, IncubyteStringCalculator.add(""));
    }

    @Test
    public void add_singleNumber_success() throws Exception {
        assertEquals(5, IncubyteStringCalculator.add("5"));
    }

    @Test
    public void add_twoNumber_success() throws Exception {
        assertEquals(8, IncubyteStringCalculator.add("5,3"));
    }

    @Test
    public void add_multipleNumbers_success() throws Exception {
        assertEquals(10, IncubyteStringCalculator.add("2,3,5"));
    }

    @Test
    public void add_NumbersWithLines_success() throws Exception {
        assertEquals(9, IncubyteStringCalculator.add("1\n5,3"));
    }

    @Test
    public void add_NUmbersWithDifferentDelimiters_success() throws Exception {
        assertEquals(3, IncubyteStringCalculator.add("//;\n1;2"));
    }

    @Test
    public void add_NegativeNumbers_success() throws Exception {
        Exception exception = assertThrows(
                Exception.class,
                () -> {
                    IncubyteStringCalculator.add("5,-1");
                }
        );

        assertEquals("negatives not allowed: -1", exception.getMessage());
    }

    @Test
    public void ignoringNumbersGreaterThan1000_success() throws Exception {
        assertEquals(8, IncubyteStringCalculator.add("4,1002,4"));
    }


    @Test
    public void add_NumbersWithDifferentSizeDelimiter_success() throws Exception {
        assertEquals(6, IncubyteStringCalculator.add("//[,,,]\n1,,,2,,,3"));
    }

    @Test
    public void add_NumbersWithMultipleDelimiters_success() throws Exception {
        assertEquals(6, IncubyteStringCalculator.add("//[*][%]\n1*2%3"));
    }
}
