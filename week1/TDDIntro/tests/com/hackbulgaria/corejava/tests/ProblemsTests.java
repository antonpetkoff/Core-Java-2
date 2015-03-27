package com.hackbulgaria.corejava.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.hackbulgaria.corejava.Problems;
import com.hackbulgaria.corejava.ProblemsImpl;

public class ProblemsTests {
    
    private final Problems problems = new ProblemsImpl();
    
    @Test
    public void testGetNumberOfDigits() {
        assertEquals(5, problems.getNumberOfDigits(51796));
        assertEquals(8, problems.getNumberOfDigits(10010100));
        assertEquals(3, problems.getNumberOfDigits(-934));
        assertEquals(1, problems.getNumberOfDigits(0));
    }
    
}
