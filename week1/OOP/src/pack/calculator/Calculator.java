package pack.calculator;
import pack.stack.Stack;
import pack.stack.StackImpl;

public class Calculator {
    
    private static double factorial(double n) {
        double result = 1;
        for (double i = n; i > 1.0; i -= 1.0) {
            result *= i;
        }
        return result;
    }
    
    private static int priority(Character ch) {
        if (ch == null || ch == '(') {
            return -1;
        } else if (ch == '!') {
            return 2;
        } else if (ch == '^' || ch == '*' || ch == '/') {
            return 1;
        } else if (ch == '+' || ch == '-') {
            return 0;
        }
        throw new IllegalArgumentException("Unsupported operation: " + ch);
    }

    private static String infixToPostfix(String exp) {
        Stack<Character> ops = new StackImpl<Character>();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < exp.length(); ++i) {
            if (Character.isDigit(exp.charAt(i))) {
                result.append(exp.charAt(i));
                continue;
            }
            
            if (exp.charAt(i) == ')') {
                while (!ops.peek().equals('(')) {
                    result.append(ops.pop());
                }
                ops.pop();          // discard matching parenthesis
                continue;
            }

            if ( exp.charAt(i) == '(' || ( priority(exp.charAt(i)) > priority(ops.peek())) ) {
                ops.push(exp.charAt(i));
            } else {
                while (priority(exp.charAt(i)) <= priority(ops.peek())) {
                    result.append(ops.pop());
                }
                ops.push(exp.charAt(i));
            }
        }
        
        while (!ops.isEmpty()) {
            result.append(ops.pop());
        }
        
        return result.toString();
    }
    
    private static String calculatePostfix(String exp) {
        Stack<String> vals = new StackImpl<String>();
        
        for (int i = 0; i < exp.length(); i++) {
            if (Character.isDigit(exp.charAt(i))) {
                vals.push(String.valueOf(exp.charAt(i)));
            } else {
                Double val = Double.valueOf(vals.pop());
                if (exp.charAt(i) == '+') {
                    vals.push(String.valueOf(Double.valueOf(vals.pop()) + val));
                } else if (exp.charAt(i) == '-') {
                    vals.push(String.valueOf(Double.valueOf(vals.pop()) - val));
                } else if (exp.charAt(i) == '*') {
                    vals.push(String.valueOf(Double.valueOf(vals.pop()) * val));
                } else if (exp.charAt(i) == '/') {
                    vals.push(String.valueOf(Double.valueOf(vals.pop()) / val));
                } else if (exp.charAt(i) == '^') {
                    vals.push(String.valueOf(Math.pow(Double.valueOf(vals.pop()), val)));
                } else if (exp.charAt(i) == '!') {
                    vals.push(String.valueOf(factorial(val)));
                }
            }
        }
        return vals.pop();
    }
    
    public static String evaluateExpression(String exp) {
        exp = exp.replaceAll("[^\\d()+\\-*/^!]+", "");
        return calculatePostfix(infixToPostfix(exp));
    }
    
    public static void main(String[] args) {
        Console console = new Console();
        console.writeLine("Hello!\n");
        String input = console.readLine("Enter expression:> ");
        
        while(!input.equals("exit")) {
            console.writeLine(evaluateExpression(input));
            input = console.readLine("Enter expression:> ");
        }
        console.writeLine("\nBye!");
    }
    
}
