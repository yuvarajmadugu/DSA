package DSA.Stacks.UsingLinkedList;

public class StackUsingLL {
    private Node top;

    public StackUsingLL(){
        this.top = null;
    }

    public void push(int value){
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Cant pop coz list is empty.");
        }
        int x = top.data;
        top = top.next;
        return x;
    }

    boolean isEmpty(){
        return top == null;
    }

    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("Cant peek coz list is empty.");
        }
        return top.data;
    }


    public static void main(String[] args) {
        try {
            StackUsingLL obj = new StackUsingLL();
            obj.push(10);
            obj.push(20);
            System.out.println(obj.peek());
            obj.push(30);
            System.out.println(obj.pop());
            System.out.println(obj.pop());
            System.out.println(obj.pop());
            System.out.println(obj.pop());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

}
