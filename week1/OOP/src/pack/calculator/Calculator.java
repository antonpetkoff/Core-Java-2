package pack.calculator;
import pack.stack.Stack;
import pack.stack.StackImpl;

public class Calculator {
    
    public static double factorial(double n) {
        double result = 1;
        for (double i = n; i > 1.0; i -= 1.0) {
            result *= i;
        }
        return result;
    }
    
    public static int priority(Character ch) {
        if (ch == null) {
            return -1;
        }
        
        switch (ch.charValue()) {
            case '(':
                return -1;
            case '!':
                return 2;
            case '^':
            case '*':
            case '/':
                return 1;
            case '-':
            case '+':
                return 0;
            default:
                throw new IllegalArgumentException("Unsupported operation: " + ch);
        }
        
    }
    
    public static boolean isRightAssociative(char ch) {
        return ch == '^';
    }

    public static String infixToPostfix(String exp) {
        Stack<Character> ops = new StackImpl<Character>();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < exp.length(); ++i) {
            if (exp.charAt(i) == ' ') {
                continue;
            }
            
            if (Character.isDigit(exp.charAt(i))) {
                result.append(exp.charAt(i));
                continue;
            }
            
            if (exp.charAt(i) == '(') {
                ops.push(exp.charAt(i));
                continue;
            }
            
            if (exp.charAt(i) == ')') {
                while (!ops.peek().equals('(')) {
                    result.append(ops.pop());
                }
                ops.pop();          // discard matching parenthesis
                continue;
            }

            if (priority(exp.charAt(i)) > priority(ops.peek())
                    || ((priority(exp.charAt(i)) == priority(ops.peek())) && isRightAssociative(exp.charAt(i))) ) {
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
    
    public static String calculatePostfix(String exp) {
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
                    vals.push(Double.toString(factorial(val)));
                }
            }
        }
        return vals.pop();
    }

    public static void testExpression(String expr) {
        String rpn = infixToPostfix(expr);
        System.out.println(rpn);
        System.out.println(calculatePostfix(rpn) + '\n');
    }
    
    public static void main(String[] args) {
        testExpression("3+4*2/(1-5)^2^3");
        testExpression("2^3 + (5+3)^2");
        testExpression("(2*3 + 1*3)!");
        testExpression("2^3! + 5*((3+2!)^2)");
    }
    
}
