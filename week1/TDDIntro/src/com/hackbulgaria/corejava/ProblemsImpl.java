package com.hackbulgaria.corejava;

public class ProblemsImpl implements Problems {

    @Override
    public int getNumberOfDigits(int n) {
        n = n < 0 ? -n : n;
        
        if (n < 10) {
            return 1;
        }
        
        int count = 0;
        while (n > 0) {
            n /= 10;
            ++count;
        }
        
        return count;
    }

    @Override
    public String stichMeUp(Object glue, Object... elements) {
        if (elements.length == 0) {
            return "";
        }
        if (elements.length == 1) {
            return elements[0].toString();
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < elements.length - 1; ++i) {
            result.append(elements[i].toString()).append(glue.toString());
        }
        result.append(elements[elements.length - 1].toString());
        
        return result.toString();
    }
    
}
