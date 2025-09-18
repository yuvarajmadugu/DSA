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
        System.out.println("Deleted Node: " +temp.next.data);
        temp.next = temp.next.next;
        size--;
    }
    void deleteFromPosition(int pos){
        if(head == null){
            System.out.println("Can not delete an element coz list is empty");
            return;
        }
        if(pos == 1){
            deleteFromBeginning();
            return;
        }
        //case 1: if there is no size exist
        /*
        if(pos <= 0 || pos < size){
            System.out.println("Given position is invalid can not delete");
            return;
        }
        int currentPos = 1;
        Node temp = head;
        while (currentPos < pos -1){
            temp = temp.next;
            currentPos++;
        }
        System.out.println("Deleted node: " +temp.next.data);
        temp.next = temp.next.next;
        size--;
         */

        //case2: if no size exist
        int currentPos = 1;
        Node temp, prevNode;
        prevNode = null;
        temp = head;
        while (temp != null){
            if(currentPos == pos){
                System.out.println("Deleted Node: " +temp.data);
                prevNode.next = temp.next;
                size--;
                return;
            }
            prevNode = temp;
            temp = temp.next;
            currentPos++;
        }
    }
    void deleteByValue(int value){
        if(head == null){
            System.out.println("Cant delete becoz list is empty.");
            return;
        }
        if(head.data == value){
            System.out.println("Deleted node: " +head.data);
            head = head.next;
            size--;
            return;

            //or
            //deleteFromBeginning();
            //return;
        }
        Node temp, prevNode;
        prevNode = null;
        temp = head;
        while((temp != null) && (temp.data != value)){
            prevNode = temp;
            temp = temp.next;
        }
        if(temp != null){
            System.out.println("Deleted node: "+ temp.data);
            prevNode.next = temp.next;
            size--;
        }else {
            System.out.println("No such Node exist in the list.");
        }
    }

    void findLength(){
        Node temp = head;
        int count = 0;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        System.out.println("Length of the linkedlist is: "+count);
    }
    boolean searchAnElement(int value){
        Node temp = head;
        while (temp != null){
            if(temp.data == value){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    //leetcode 206: Reverse Linkedlist
    void reverseLL(){
        if(head == null){
            System.out.println("List is empty cant reverse it.");
            return;
        }
        if (head.next == null){
            System.out.println("Only 1 element in the list.");
            System.out.println(head.data);
            return;
        }
        //to reverse connection from forward traversal to backward
        Node temp, prevNode, nextNode;
        temp = head;
        prevNode = null;
        while (temp != null){
            nextNode = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = nextNode;
        }
        head = prevNode;
        //to print onto the console
        Node temp2 = prevNode;
        while(temp2 != null){
            System.out.print(temp2.data +" ");
            temp2 = temp2.next;
        }
    }







    int CountNodes(Node head){
        if (head == null){
            return 0;
        }
        int count = 0;
        Node temp = head;
        do {
            count++;
            temp = temp.next;
        }while(temp != head);
        //System.out.println(count);
        return count;
    }


    public static void main(String[] args) {
        SinglyLL sll = new SinglyLL();
        sll.insertAtBeginning(10);
        sll.insertAtBeginning(20);
        sll.insertAtBeginning(30);
        sll.insertAtBeginning(40);
        sll.insertAtBeginning(50);
        sll.insertAtBeginning(60);
        sll.insertAtBeginning(70);
        sll.traverseLL();
        sll.insertAtEnd(35);
        sll.traverseLL();
        sll.insertAtPosition(22,2);
        sll.traverseLL();
        sll.insertAfterValue(95,35);
        sll.traverseLL();
        sll.deleteFromBeginning();
        sll.traverseLL();
        sll.deleteFromEnd();
        sll.traverseLL();
        sll.deleteFromPosition(1);
        sll.traverseLL();
        sll.deleteByValue(58);
        sll.traverseLL();
        sll.findLength();
        boolean ans = sll.searchAnElement(56);
        System.out.println(ans);
        sll.traverseLL();
        sll.reverseLL();




    }
}
