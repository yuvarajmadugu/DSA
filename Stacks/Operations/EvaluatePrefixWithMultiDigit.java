package DSA.Stacks.Operations;

import java.util.Stack;

public class EvaluatePrefixWithMultiDigit {

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

    static int evaluatePrefixWithMultiDigitmethod(char[] exp){
        Stack<Integer> stack = new Stack<>(); //SC=o(n)
        int i = exp.length-1;
        while (i >= 0) { //TC = 0(n)
            if(exp[i] == ' '){
                i--;
                continue;
            }
            char ch = exp[i];
            if(isOperator(ch)) {
                int operator1 = stack.pop();
                int operator2 = stack.pop();
                int updatedOperator = compute(ch, operator1, operator2);
                stack.push(updatedOperator);
                i--;
            }
            else if (Character.isDigit(ch)) {
                StringBuilder num = new StringBuilder(); //SC = o(k)
                while (i>=0 && Character.isDigit(exp[i])) { //TC = o(k)
                    num.insert(0, exp[i]);
                    i--;
                }
                stack.push(Integer.parseInt(num.toString()));
            } else {
                throw new IllegalArgumentException("Invalid char " +ch);
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        try{
            String prefix = "+ 10 * 2 3";
            char[] charArrRef = prefix.toCharArray();  //['+',' ','1','0',' ','*',' ','2',' ','3']
            int output = evaluatePrefixWithMultiDigitmethod(charArrRef);
            System.out.println("Output of Prefix expression with multi digit is: " +output);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
