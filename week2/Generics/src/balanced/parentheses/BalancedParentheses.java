package balanced.parentheses;

import java.util.Stack;

public class BalancedParentheses {

    public static boolean checkBracketsExpression(String str) {        
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                stack.pop();
            }
        }
        
        return stack.size() == 0;
    }
    
    public static void main(String[] args) {
        System.out.println(checkBracketsExpression(")(())(()())((()))"));
        System.out.println(checkBracketsExpression(")()()()"));
    }
    
}
