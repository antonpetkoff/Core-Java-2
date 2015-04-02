package pack.calculator;
import pack.stack.Stack;
import pack.stack.StackImpl;

public class Calculator {
    
    public static String presedence = "(^*/+-";
    
    public static int priority(Character ch) {
        if (ch == null) {
            return -1;
        }
        
        switch (ch.charValue()) {
            case '(':
                return -1;
            case '^':
                return 2;
            case '*':
            case '/':
                return 1;
            case '-':
            case '+':
                return 0;
            default:
                System.out.println(ch);
                throw new IllegalArgumentException("Unsupported operation!");
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
                System.out.println("peek() before )while: " + ops.peek());
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
        // TODO
        return null;
    }

    public static void main(String[] args) {
        System.out.println(infixToPostfix("3+4*2/(1-5)^2^3"));
    }
    
}
