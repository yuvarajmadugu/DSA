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
        if(head == null){
            //newNode.next = head;
            //head = newNode;
            //or
            insertAtBeginning(data);
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
        //If there is no tail:
//        Node temp = head;
//        while(temp.next != null){
//            temp = temp.next;
//        }
//        temp.next = newNode;
//        size++;
    }

    void insertAtPosition(int data, int pos){
        Node newNode = new Node(data);
        if(pos <= 0 || pos > size+1){
            System.out.println("Position in-valid.");
            return;
        }
        if(head == null){
            if(pos == 1){
                insertAtBeginning(data);
                return;
            }
        }
        if(pos == 1){
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        int currentPos = 1;
        Node temp = head;
        while (currentPos < pos-1){
            temp = temp.next;
            currentPos++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    void insertAfterValue(int data, int value){
        Node newNode = new Node(data);
        Node temp = head;
        while ((temp != null) && (temp.data != value)){
            temp = temp.next;
        }
        if (temp != null){
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }else {
            System.out.println("No such value exists in the list. So insertion can not be done.");
        }
    }

    void deleteFromBeginning(){
        if(head == null){
            System.out.println("Cant delete coz list is empty");
            return;
        }
        System.out.println("Deleted node: "+ head.data);
        head = head.next;
        size--;
        if(head == null){
            tail = null;
        }
    }

    void deleteFromEnd(){
        if(head == null){
            System.out.println("Cant delete because list is empty.");
            return;
        }
        if(head.next == null){
            System.out.println("Deleted Node: " +head.data);
            head = head.next;
            tail = null;
            size--;
            return;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        System.out.println("De");
    }


    public static void main(String[] args) {
        SinglyLL sll = new SinglyLL();
        sll.insertAtBeginning(10);
        sll.insertAtBeginning(20);
        sll.traverseLL();
        sll.insertAtEnd(35);
        sll.traverseLL();
        sll.insertAtPosition(22,2);
        sll.traverseLL();
        sll.insertAfterValue(95,35);
        sll.traverseLL();
        sll.deleteFromBeginning();
        sll.traverseLL();

    }
}
