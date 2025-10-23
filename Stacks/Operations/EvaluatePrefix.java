package DSA.Stacks.Operations;

import java.util.Stack;

public class EvaluatePrefix {
    static boolean isOperator(char op){
        return op == '+' || op == '-' || op == '*' || op == '/' || op == '^';
    }
    static int compute(char operator, int operand1, int operand2){
        return switch (operator) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> operand1 / operand2;
            case '^' -> operand1 ^ operand2;
            default -> throw new IllegalArgumentException();
        };
    }
    static int evaluatePrefix(String expression){
        Stack<Integer> stack = new Stack<>();
        for(int i=expression.length()-1; i>=0; i--){
            char ch = expression.charAt(i);
            if(Character.isDigit(ch)){
                stack.push(ch-'0');
            }
            else if(isOperator(ch)) {
                int operator1 = stack.pop();
                int operator2 = stack.pop();
                int updatedOperator = compute(ch, operator1, operator2);
                stack.push(updatedOperator);
            }
            else {
                throw new IllegalArgumentException("Invalid char " +ch);
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        try{
            String prefix = "*2+21";
            int output = evaluatePrefix(prefix);
            System.out.println(output);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
