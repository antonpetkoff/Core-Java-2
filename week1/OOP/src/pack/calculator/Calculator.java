package pack.calculator;
import pack.stack.Stack;
import pack.stack.StackImpl;

public class Calculator {

    public static String infixToPostfix(String exp) {
        Stack<String> ops = new StackImpl<String>();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < exp.length(); ++i) {
            if (Character.isDigit(exp.charAt(i))) {
                
            }
        }
        
        return result.toString();
    }
    
    public static String calculatePostfix(String exp) {
        // TODO
        return null;
    }
//    
//    public static String calculate(String exp) {
//        Stack<String> ops = new StackImpl<String>();
//        Stack<String> vals = new StackImpl<String>();
//        
//        for (int i = 0; i < exp.length(); ++i) {
//            if (exp.charAt(i) == ' ' || exp.charAt(i) == '(') {
//                continue;
//            }
//            if (exp.charAt(i) == '+' || exp.charAt(i) == '-'
//                || exp.charAt(i) == '*' || exp.charAt(i) == '/') {
//                ops.push(String.valueOf(exp.charAt(i)));
//            } else if (exp.charAt(i) == ')') {
//                String op = ops.pop();
//                String val = vals.pop();
//                
//                if (op.equals("+")) {
//                    vals.push(String.valueOf(Double.valueOf(vals.pop()) + Double.valueOf(val)));
//                } else if (op.equals("-")) {
//                    vals.push(String.valueOf(Double.valueOf(vals.pop()) - Double.valueOf(val)));
//                } else if (op.equals("*")) {
//                    vals.push(String.valueOf(Double.valueOf(vals.pop()) * Double.valueOf(val)));
//                } else if (op.equals("/")) {
//                    vals.push(String.valueOf(Double.valueOf(vals.pop()) / Double.valueOf(val)));
//                }
//
//            } else {
//                vals.push(String.valueOf(exp.charAt(i)));
//            }
//        }
//        return vals.pop();
//    }
//    
    public static void main(String[] args) {
//        String exp = "3 + (5 + 9*7 + 9) ";
//        System.out.println(calculate(exp));
    }
    
}
