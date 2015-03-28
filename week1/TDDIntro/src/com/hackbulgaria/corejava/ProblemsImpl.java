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

    @Override
    public String reduceFilePath(String path) {
        path = path.replaceAll("/{2,}", "/");
        
        if (path.length() == 1) {
            return path;
        }
        
        StringBuilder result = new StringBuilder();
        String[] terms = path.split("/");           // leaves empty strings and "/"

        for (int i = 0; i < terms.length; ++i) {
            if (terms[i].equals(".") || terms[i].equals("..") 
                || terms[i].isEmpty() || terms[i].equals("/")) {
                continue;
            }
            
            if ((i + 1 < terms.length) && (terms[i + 1].equals(".."))) {
                terms[i] = terms[i+1] = "";
                continue;
            }
            
            result.append("/" + terms[i]);
        }
        
        return result.length() == 0 ? "/" : result.toString();
    }

    @Override
    public String reduceFilePathRegex(String path) {
        path = path.replaceAll("/{2,}", "/");       // remove duplicating splitters /
        path = path.replaceAll("/.+/\\.{2}", "");   // handle ..'s
        path = path.replaceAll("/\\./", "");        // handle .'s
        path = path.replaceAll("\\.", "");          // clean up remaining .'s

        if (path.length() == 1) {
            return "/";
        }
        
        return path.charAt(path.length() - 1) == '/' ? path.substring(0, path.length() - 1) : path;
    }
    
}
