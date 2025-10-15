package DSA.Stacks.Operations;

import java.util.Stack;
//conversion from infix expression to postfix expression
public class InfixToPostfix {
    static int precedence(char operator){
        switch (operator){
            case '^' : return 3; //highest precedence
            case '/','*' : return 2;
            case '+','-' : return 1; //lowest precedence
        }
        return -1;
    }

    static boolean isRightAssociative(char operator){
        return operator == '^'; //if these then right associative else left associative
    }

    static String infixToPostfix(String expression){
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>(); //operators like +,- are internally stored in the form of character only
        for(char ch: expression.toCharArray()){ //since stack is a logical ds it needs a physical ds
            if(Character.isLetterOrDigit(ch)){  //a,b or 1,2
                output.append(ch);
            }else if (ch == '('){
                stack.push(ch);
            }else if (ch == ')'){
                while (!stack.isEmpty() && stack.peek() != '(' ){
                    output.append(stack.pop()); //stack me jo pop hua vo output me append ho jana
                }
                stack.pop(); //to pop '(' from stack
            }
            //leftover cases like the incoming characters precedence is having lower or higher and also associativity
            else {
                //if incoming character is having higher precedence then pop check again if still true again pop until the precedence is low
                while(!stack.isEmpty() && stack.peek() != '(' &&
                        (precedence(ch) <= precedence(stack.peek())
                                || precedence(ch) == precedence(stack.peek()) && /*if same precedence then check associativity*/ !isRightAssociative(ch))){
                    output.append(stack.pop());
                }
                //if incoming character is having higher precedence: then push
                stack.push(ch);
            }
        }
        //this while loop is for worst case handling where all the operators are there in the stack after completion of operands(a,b) to empty stack and append leftover operators to the output
        while (!stack.isEmpty()){
            output.append(stack.pop());
        }
        return output.toString(); //convert string-builder output to string to print onto the console
    }

    public static void main(String[] args) {
        String expression = "a+b*c";
        String postfix = infixToPostfix(expression);
        System.out.println("Postfix: " +postfix);
    }
}
