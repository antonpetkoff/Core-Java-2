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
    
    @Test
    public void testStichMeUp() {
        assertEquals("Neiko lapa slivi", problems.stichMeUp(" ", "Neiko", "lapa", "slivi"));
        assertEquals("10203040506", problems.stichMeUp(0, 1, 2, 3, 4, 5, 6));
        assertEquals("5-36-37-37.0-38", problems.stichMeUp(-3, 5, 6, 7.0, 8));
        assertEquals("sad 3.14 \t 3.14 false 3.14 test", problems.stichMeUp(" " + 3.14 + " ", "sad", "\t", false, "test"));
        assertEquals("1", problems.stichMeUp("", 1));
        assertEquals("1", problems.stichMeUp("asd", 1));
        assertEquals(" ", problems.stichMeUp("", " ", "", ""));
    }
    
}
