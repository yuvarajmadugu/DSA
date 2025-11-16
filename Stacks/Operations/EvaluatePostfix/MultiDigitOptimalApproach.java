package DSA.Stacks.Operations.EvaluatePostfix;

import java.util.Stack;

public class MultiDigitOptimalApproach {
    static boolean isOperator(String op){
        return op.equals("+") || op.equals("-") || op.equals("/") || op.equals("*") || op.equals("^");
    }
    static int compute(String operator, int operand1, int operand2){
        return switch (operator) {
            case "+" -> operand2 + operand1;
            case "-" -> operand2 - operand1;
            case "*" -> operand2 * operand1;
            case "/" -> operand2 / operand1;
            default -> throw new IllegalArgumentException();
        };
    }

    static int evaluatePostfixWithMultiDigitOptimalApproachMethod(String exp){
        String[] strArr = exp.trim().split("\\s+");
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i< strArr.length; i++){
            String token = strArr[i];
            if(isOperator(token)) {
                int operator1 = stack.pop();
                int operator2 = stack.pop();
                int updatedOperator = compute(token, operator1, operator2);
                stack.push(updatedOperator);
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        try{
            String postfix = "10 6 *";
            int output = evaluatePostfixWithMultiDigitOptimalApproachMethod(postfix);
            System.out.println("Output of Postfix expression with multi digit is: " +output);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
