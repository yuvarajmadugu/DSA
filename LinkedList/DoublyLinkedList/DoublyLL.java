package DSA.LinkedList.DoublyLinkedList;

public class DoublyLL {
    private Node head;
    private Node tail;
    private int size;

    Node insertAtBeginning(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            size++;
            return head;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
        return head;
    }
    void traverseDLL(Node head){
        if (head == null){
            System.out.println("List is empty.");
            return;
        }else {
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data +" ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        Node head;
        head = dll.insertAtBeginning(10);
        head = dll.insertAtBeginning(20);
        head = dll.insertAtBeginning(30);
        head = dll.insertAtBeginning(40);
        head = dll.insertAtBeginning(50);
        head = dll.insertAtBeginning(60);
        head = dll.insertAtBeginning(70);
        dll.traverseDLL(head);
    }
}
