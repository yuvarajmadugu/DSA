package DSA.Stacks.Operations;

import java.util.Stack;

public class PrefixToInfix {
    static String prefixToInfix(String expression){
        Stack<String> stack = new Stack<>();
        for(int i=expression.length()-1; i>=0; i--){
            char ch = expression.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(ch+"");
            }
            else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String updatedExpression = "("+operand1+ch+operand2+")";
                stack.push(updatedExpression);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String expression = "-+a*bc-/de+fg";
        String output = prefixToInfix(expression);
        System.out.println("Infix: " +output);
    }
}
