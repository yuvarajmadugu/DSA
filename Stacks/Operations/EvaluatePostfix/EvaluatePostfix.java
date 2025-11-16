package DSA.Stacks.Operations.EvaluatePostfix;

import java.util.Stack;

public class EvaluatePostfix {
    static boolean isOperator(char op){
        return op == '+' || op == '-' || op == '*' || op == '/' || op == '^';
    }
    static int compute(char operator, int operand1, int operand2){
        return switch (operator) {
            case '+' -> operand2 + operand1;
            case '-' -> operand2 - operand1;
            case '*' -> operand2 * operand1;
            case '/' -> operand2 / operand1;
            case '^' -> operand2 ^ operand1;
            default -> throw new IllegalArgumentException();
        };
    }
    static int evaluatePrefix(String expression){
        Stack<Integer> stack = new Stack<>();
        int i=0;
        while (i<expression.length()) {
            char ch = expression.charAt(i);
            if(Character.isDigit(ch)){
                //in evaluation if character is a number, it is in the form of SI value (for eg. 0=48, 1=49, 2=50, 3=51)
                //to store character value instead of SI value here a small formula is used i.e char-'0' //character zero
                stack.push(ch-'0'); //character zero
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
            i++;
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        try{
            String prefix = "126*-";
            int output = evaluatePrefix(prefix);
            System.out.println("Output of Postfix expression is: " +output);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
