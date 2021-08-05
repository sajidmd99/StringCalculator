package com.sajid;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
