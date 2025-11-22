package DSA.Stacks.Leetcode;

import java.util.Stack;

public class ValidParentheses {
    static boolean checkValidParentheses(String str){
        Stack <Character> stack = new Stack<>();
        for (int i = 0; i< str.length(); i++){
            char ch = str.charAt(i);
//            if(Character.isLetterOrDigit(ch)){
//                return true ;
//            }
            if(ch != '(' && ch != '{' && ch != '[' && ch != ')' && ch != '}' && ch != ']'){
                continue;
            }
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else {
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if( (ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[') ) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "{}(){}[]";
        boolean result = checkValidParentheses(str);
        System.out.println(result);
    }

}
