package DSA.Stacks.Operations;

import java.util.Stack;

public class InfixToPrefix {
    static int precedence(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '/', '*':
                return 2;
            case '+', '-':
                return 1;
        }
        return -1;
    }

    static String reverseNdSwap(String str) {
        StringBuilder rev = new StringBuilder();
        //to reverse the given str we read it from backwards
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            if (ch == '(') {
                rev.append(')');
            } else if (ch == ')') {
                rev.append('(');
            } else {
                rev.append(ch);
            }
        }
        return rev.toString();
    }


    static String infixToPostfix(String expression) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                output.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop()); //stack me jo pop hua vo output me append ho jana
                }
                stack.pop(); //to pop '(' from stack
            }
            //leftover cases like the incoming characters precedence is having lower or higher and also associativity
            else {
                while (!stack.isEmpty() && stack.peek() != '(' &&
                        (precedence(ch) <= precedence(stack.peek())
                                || precedence(ch) == precedence(stack.peek()) && ch == '^')) {
                    output.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        //this while loop is for worst case handling where all the operators are there in the stack after completion of operands(a,b) to empty stack and append leftover operators to the output
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }
        return output.toString(); //convert string-builder output to string to print onto the console
    }


    static String infixToPrefix(String expression) {
        String updatedExpression = reverseNdSwap(expression);
        String postfix = infixToPostfix(updatedExpression);
        return new StringBuilder(postfix).reverse().toString();
    }

    public static void main(String[] args) {
        String expression = "a+b*c";
        String output = infixToPrefix(expression);
        System.out.println("Prefix: " + output);
    }

}
