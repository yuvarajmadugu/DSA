package DSA.LinkedList.CircularDoublyLinkedList;

public class CircularDLL {
    private Node head, tail;
    private int size;

    Node insertAtBeginning(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            head.next = head;
            head.prev = head;
            size++;
            return head;
        }
        newNode.next = head;
        newNode.prev = tail;
        head.prev = newNode;
        tail.next = newNode;
        head = newNode;
        size++;
        return head;
    }
    void traverseCDLL(Node head){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data +" ");
            temp = temp.next;
        }while (temp != head);
        System.out.println();
    }
    void reversetraverseCDLL(Node head){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        Node temp = head.prev;
        do {
            System.out.print(temp.data +" ");
            temp = temp.prev;
        }while (temp != head.prev);
        System.out.println();
    }
    Node insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            head.next = head;
            head.prev = head;
            size++;
            return head;
        }
        //case1: when there are both head and tail:
        /*newNode.next = head;
        newNode.prev = tail;
        tail.next = newNode;
        head.prev = newNode;
        tail = newNode;
        size++;
        return head;
         */

        //case2: if there is no tail:
        newNode.next = head;
        newNode.prev = head.prev;
        head.prev.next = newNode;
        head.prev = newNode;
        size++;
        return head;
    }
    Node insertAtPosition(int data, int pos){
        if(pos <= 0){
            System.out.println("Position invalid cant insert.");
            return head;
        }
        if(pos == 1){
            return insertAtBeginning(data);
        }
        Node temp = head;
        Node newNode = new Node(data);
        int currentPos = 1;
        do{
            if(currentPos == pos){
                break;
            }
            temp = temp.next;
            currentPos++;
        }while (temp != head);
        if(temp == head){
            System.out.println("Position invalid, cant insert.");
            return head;
        }
        Node prevNode = temp.prev;
        newNode.next = temp;
        newNode.prev = prevNode;
        prevNode.next = newNode;
        temp.prev = newNode;
        size++;
        return head;
    }
    Node insertAfterValue(int data, int value){
        Node newNode = new Node(data);
        if(head == null){
            System.out.println("No such value exist, cant insert.");
            return head;
        }
        if(head.data == value){
            newNode.next = head.next;
            newNode.prev = head;
            head.next.prev = newNode;
            head.next = newNode;
            size++;
            return head;
        }
        Node temp = head;
        do{
            if(temp.data == value){
                break;
            }
            temp = temp.next;
        }while (temp != head);
        Node nextNode = temp.next;
        newNode.next = nextNode;
        newNode.prev = temp;
        temp.next = newNode;
        size++;
        return head;
    }
    Node deleteFromHead(Node head){
        if(head == null){
            System.out.println("List is empty, so cant delete.");
            return head;
        }
        if(head.next == head){
            head.next = null;
            head.prev = null;
            tail = null;
            head = null;
            size--;
            return head;
        }
        Node temp = head;
        head = head.next;
        head.prev = temp.prev;
        temp.prev.next = head;
        temp.next = null;
        temp.prev = null;
        size--;
        return head;
    }
    Node deleteFromEnd(Node head){
        if(head == null){
            System.out.println("List is empty, so cant delete.");
            return head;
        }
        if(head.next == head){
            head.next = null;
            head.prev = null;
            tail = null;
            head = null;
            size--;
            return head;
        }
        Node temp = head.prev;
        temp.prev.next = head;
        head.prev = temp.prev;
        tail = temp.prev;
        temp.next = null;
        temp.prev = null;
        size--;
        return head;
    }
    Node deleteFromPosition(Node head, int pos){
        if(head == null){
            System.out.println("List is empty, so cant delete.");
            return head;
        }
        if(pos ==1){
            return deleteFromHead(head);
        }
        Node temp = head;
        int currentPos = 1;
        do{
            if(currentPos == pos){
                break;
            }
            temp = temp.next;
            currentPos++;
        }while (temp != head);
        if(temp == head){
            System.out.println("Not a valid position, cant delete.");
            return head;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev = null;
        size--;
        return head;
    }
    Node deleteByValue(Node head, int value){
        if(head == null){
            System.out.println("List is empty, so cant delete.");
            return head;
        }
        if(head.data == value){
            return deleteFromHead(head);
        }
        Node temp = head;
        do{
            if (temp.data == value){
                break;
            }
            temp = temp.next;
        }while (temp != head);
        if(temp == head){
            System.out.println("Not a valid position, cant delete.");
            return head;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev = null;
        size--;
        return head;
    }


    public static void main(String[] args) {
        CircularDLL cdll = new CircularDLL();
        Node head = null;

        head = cdll.insertAtBeginning(10);
        head = cdll.insertAtBeginning(20);
        head = cdll.insertAtBeginning(30);
        head = cdll.insertAtBeginning(40);
        head = cdll.insertAtBeginning(50);
        head = cdll.insertAtBeginning(60);
        head = cdll.insertAtBeginning(70);
        cdll.traverseCDLL(head);
        cdll.reversetraverseCDLL(head);

//        head = cdll.insertAtEnd(25);
//        cdll.traverseCDLL(head);

//        head = cdll.insertAtPosition(59,3);
//        cdll.traverseCDLL(head);

//        head = cdll.insertAfterValue(48,70);
//        cdll.traverseCDLL(head);

//        head = cdll.deleteFromHead(head);
//        cdll.traverseCDLL(head);

//        head = cdll.deleteFromEnd(head);
//        cdll.traverseCDLL(head);

//        head = cdll.deleteFromPosition(head,2);
//        cdll.traverseCDLL(head);

        head = cdll.deleteByValue(head,20);
        cdll.traverseCDLL(head);


    }
}
