package DSA.Stacks.Operations.EvaluatePostfix;

import java.util.Stack;

public class EvaluatePostfixWithMultDigit {
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

    static int evaluatePostfixWithMultiDigitmethod(String exp){
        Stack<Integer> stack = new Stack<>(); //SC=o(n)
        char[] charArr = exp.toCharArray();
        int i = 0;
        while (i < charArr.length) { //TC = 0(n)
            if(charArr[i] == ' '){
                i++;
                continue;
            }
            char ch = charArr[i];
            if(isOperator(ch)) {
                int operator1 = stack.pop();
                int operator2 = stack.pop();
                int updatedOperator = compute(ch, operator1, operator2);
                stack.push(updatedOperator);
                i++;
            }
            else if (Character.isDigit(ch)) {
                int num = 0;
                while (i<charArr.length && Character.isDigit(charArr[i])) { //TC = o(k)
                    num = num*10 + (charArr[i]-'0');
                    i++;
                }
                stack.push(num);
            } else {
                throw new IllegalArgumentException("Invalid char " +ch);
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        try{
            String prefix = "10 6*";
            int output = evaluatePostfixWithMultiDigitmethod(prefix);
            System.out.println("Output of Postfix expression is: " +output);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
