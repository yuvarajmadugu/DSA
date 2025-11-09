package DSA.Stacks.Operations;

import java.util.Stack;

public class EvaluatePrefixWithMultiDigitOptimalApproach {
    static boolean isOperator(String op){
        return op.equals("+") || op.equals("-") || op.equals("/") || op.equals("*") || op.equals("^");
    }
    static int compute(String operator, int operand1, int operand2){
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            case "^" -> operand1 ^ operand2;
            default -> throw new IllegalArgumentException("Invalid char" +operator);
        };
    }

    static int evaluatePrefixWithMultiDigitOptimalApproachMethod(String exp){
        String[] strArr = exp.trim().split("\\s+");
        Stack<Integer> stack = new Stack<>();

        for(int i=strArr.length-1; i>=0; i--){
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
            String prefix = "+ 10 * 2 3";
            int output = evaluatePrefixWithMultiDigitOptimalApproachMethod(prefix);
            System.out.println("Output of Prefix expression with multi digit is: " +output);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
