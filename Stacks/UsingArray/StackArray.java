package DSA.Stacks.UsingArray;

public class StackArray {
    protected int[] stackArray;
    protected int top;

    public StackArray(int size){
        stackArray = new int[size];
        top = -1;
    }

    public void push(int element){
        if(isFull()){
            System.out.println("Cant push coz list is full.");
            return;
        }
        top++;
        stackArray[top] = element;
    }

    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Cant pop coz list is empty.");
        }
        int x = stackArray[top];
        top--;
        return x;
    }

    boolean isFull(){
        return top == stackArray.length-1;
    }

    boolean isEmpty(){
        return top == -1;
    }

    int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("Cant peek coz list is empty.");
        }
        int x = stackArray[top];
        return x;
    }


    public static void main(String[] args) {
        try{
            StackArray stackobj = new StackArray(5);
            stackobj.push(10);
            stackobj.push(20);
            stackobj.push(30);
            System.out.println(stackobj.pop()); //30
            System.out.println(stackobj.pop()); //20
            System.out.println(stackobj.peek()); //10
            System.out.println(stackobj.pop()); //10
            System.out.println(stackobj.pop()); //Cant pop coz list is empty.
            System.out.println(stackobj.peek()); //cant reach line coz catch block is handled above

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
