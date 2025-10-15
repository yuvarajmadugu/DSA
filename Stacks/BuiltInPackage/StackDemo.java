package DSA.Stacks.BuiltInPackage;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(1);

        System.out.println(stack.size()); //3
        System.out.println(stack.isEmpty()); //false
        System.out.println(stack.empty()); //false
        System.out.println(stack.pop()); //1
        System.out.println(stack.peek()); //20

        /*
        while(!(stack.isEmpty())){
            System.out.println(stack.pop());
        }
         */



        //if you want to store all types of data object the root of all classes can be used:
        Stack <Object> st = new Stack<>();
        st.push(10);
        st.push(20.33);
        st.push(36.49f);
        st.push('a');
        st.push("Uv rocks");
        //printing on to the console
        while(!(stack.isEmpty())){
            System.out.println(stack.pop());
        }


        
    }
}
