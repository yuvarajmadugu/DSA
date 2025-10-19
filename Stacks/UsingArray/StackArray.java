package DSA.Stacks.UsingArray;

public class StackArray {
    protected int[] stackArray;
    protected int top;
    protected int maxSize;

    public StackArray(int size){
        maxSize = size;
        stackArray = new int[size];
        top = -1;
    }

    //dynamic resizing creating array resolving size issues:
    public void resize(){
        maxSize = maxSize*2;
        int[] newArray = new int[maxSize];
        for(int i=0; i<stackArray.length; i++){
            newArray[i] = stackArray[i];
        }
        stackArray = newArray;
    }

    public void push(int element){
        if(isFull()){
            resize();
            //System.out.println("Cant push coz list is full.");
            //;
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
