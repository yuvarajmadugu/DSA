package DSA.Stacks.Operations;

import java.util.Stack;

public class PostfixToInfix {
    static String postfixToInfix(String expression){
        Stack<String> stack = new Stack<>();
        for(char ch : expression.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                stack.push(ch+""); //since stack is generics takes only String
            }
            else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String updatedExpression = "("+operand2+ch+operand1+")";
                stack.push(updatedExpression);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String expression = "ab+ef/+";
        String output = postfixToInfix(expression);
        System.out.println("Infix: " +output);
    }
}
