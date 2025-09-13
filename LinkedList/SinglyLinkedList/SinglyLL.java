package DSA.LinkedList.SinglyLinkedList;

public class SinglyLL {
    private Node head;
    private Node tail;
    private int size;

    void insertAtBeginning(int data){
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
        if(tail == null){
            tail = newNode;
        }
        size++;
    }

    void traverseLL(){
        Node temp = head;
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        while (temp != null){
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    void insertAtEnd(int data){
        Node newNode = new Node(data);
        
    }


    public static void main(String[] args) {
        SinglyLL sll = new SinglyLL();
        sll.insertAtBeginning(10);
        sll.insertAtBeginning(20);
        sll.traverseLL();
    }
}
