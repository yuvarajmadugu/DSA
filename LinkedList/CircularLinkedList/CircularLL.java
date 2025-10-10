package DSA.LinkedList.CircularLinkedList;

public class CircularLL {
    private Node head;
    private Node tail;
    private int size;

    void traverseLL(){
        Node temp = head;
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    Node insertAtBeginning(int data){
        Node newNode = new Node(data);
//        if (tail == null){
//            tail = newNode;
//            tail.next = tail;
//            size++;
//            return tail;
//        }
        if (head == null){
            head = newNode;
            tail = newNode;
            head.next = head;
            size++;
            return head;
        }
        //case1: we have both head & tail:
        /*tail.next = newNode;
        newNode.next = head;
        head = newNode;
        size++;
        return head;
         */

        //case2: we have only head:
        /*Node temp = head;
        do{
            temp = temp.next;
        }while (temp.next != head);
        temp.next = newNode;
        newNode.next = head;
        head = newNode;
        size++;
        return head;
         */

        //case3: we have only tail:
        head = tail.next;
        newNode.next = head;
        tail.next = newNode;
        head = newNode;
        size++;
        return head;
    }
    void traversalCLL(Node head){
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
    Node insertAtEnd(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            tail = newNode;
            head.next = head; //to form circularity
            size++;
            return head;
        }
        //case1: we have both head and tail:
        /*tail.next = newNode;
        newNode.next = head;
        tail = newNode;
        size++;
        return head;
         */

        //case2: we only have head:
        /*Node temp = head;
        while (temp.next != head){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
        temp = newNode; //since we have only head for further access updating temp
        size++;
        return head;
         */

        //case3: we only have tail:
        Node temp = tail.next;
        tail.next = newNode;
        newNode.next = temp;
        tail = newNode;
        size++;
        return head;
    }
    Node insertBeforePosition(int data, int pos){
        Node newNode = new Node(data);
        if (pos <= 0){
            System.out.println("Position invalid, so can't, insert.");
            return head;
        }
        if(pos == 1){
            return insertAtBeginning(data);
        }
        Node temp, preNode;
        preNode = null;
        temp = head;
        int currentPos = 1;
        do{
            if(currentPos == pos){
                break;
            }
            preNode = temp;
            temp = temp.next;
            currentPos++;
        }while (temp != head);
        if (temp == head){
            System.out.println("Not a valid position. So, cant insert.");
            return head;
        }
        newNode.next = preNode.next;
        preNode.next = newNode;
        size++;
        return head;
    }
    Node insertAfterValue(int data, int value){
        Node newNode = new Node(data);
        if(head == null){
            System.out.println("No such value exist.");
            return head;
        }
        if (head.data == value){
            newNode.next = head.next;
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
        if(temp == head){
            System.out.println("No such value exist.");
            return head;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
        return head;
    }

    Node deleteFromHead(Node head){
        if(head == null){
            System.out.println("No such value exist.");
            return head;
        }
        if(head.next == head){
            head.next = null;
            head = null;
            tail = null;
            size--;
            return head;
        }

        //case1: we have both head and tail:
        /*Node temp = head;         //No temp required also
        tail.next = head.next;
        head = head.next;           //head.next = null;
        temp.next = null;           //head = tail.next;
        size--;
        return head;
         */

        //case2: we have only head:
        /*Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next = head.next;
        head.next = null;
        head = temp.next;
        size--;
        return head;
         */

        //case3: we have only tail:
        Node temp = tail.next;
        tail.next = temp.next;
        temp.next = null;
        return tail;
    }
    Node deleteFromEnd(Node head){
        //case1: we have both head and tail:
        /*Node temp = head;
        Node prevNode = null;
        do{
            prevNode = temp;
            temp = temp.next;
        }while (temp.next != head);
        prevNode.next = temp.next;
        tail = prevNode;
        size--;
        return head;
         */

        //this can also be written as:
        Node temp = head;
        while(temp.next.next != head){
            temp = temp.next;
        }
        Node nextNode = temp.next;
        temp.next = nextNode.next;
        nextNode.next = null;
        tail = temp;
        size--;
        return head;
    }
    Node deleteFromPosition(Node head, int pos){
        if (head == null){
            System.out.println("List is empty so cant delete.");
            return head;
        }
        if (pos == 1){
            return deleteFromHead(head);
        }
        Node temp = head;
        Node prevNode = null;
        int currentPos = 1;
        do{
            if(currentPos == pos){
                break;
            }
            prevNode = temp;
            temp = temp.next;
            currentPos++;
        }while (temp != head);
        if(temp == head) {
            System.out.println("Not a valid position cant delete.");
            return head;
        }
        prevNode.next = temp.next;
        temp.next = null;
        size--;
        return head;
    }
    Node deleteByValue(Node head, int value){
        if (head == null){
            System.out.println("List is empty so cant delete.");
            return head;
        }
        if(head.data == value){
            return deleteFromHead(head);
        }
        Node temp = head;
        Node prevNode = null;
        do{
            if(temp.data == value){
                break;
            }
            prevNode = temp;
            temp = temp.next;
        }while (temp != head);
        if (temp == head){
            System.out.println("No such value exist cant delete.");
            return head;
        }
        prevNode.next = temp.next;
        temp.next = null;
        size--;
        return head;
    }

    //coding exercises:
    int countNodes(Node head){
        if(head == null){
            return 0;
        }
        Node temp = head;
        int count = 0;
        do{
            count++;
            temp = temp.next;
        }while (temp != head);
        return count;
    }
    int searchNode(Node head, int value){
        if(head == null){
            return -1;
        }
        Node temp = head;
        int position = 1;
        do{
            if(temp.data == value){
                return position; // true
            }
            temp = temp.next;
            position++;
        }while (temp != head);
        return -1; //false
    }
    Node convertCLLtoSLL(Node head){
        if(head == null){
            return head;
        }
        Node temp = head;
        while (temp.next != head){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }



    public static void main(String[] args) {
        Node head = null;
        CircularLL cll = new CircularLL();

        head = cll.insertAtBeginning(10);
        head = cll.insertAtBeginning(20);
        head = cll.insertAtBeginning(30);
        head = cll.insertAtBeginning(40);
        head = cll.insertAtBeginning(50);
        head = cll.insertAtBeginning(60);
        head = cll.insertAtBeginning(70);

        cll.traversalCLL(head);
//
//        //you can check where our head/tail is:
//        System.out.println(cll.head.data);
//        System.out.println(cll.tail.data);
//
//        head = cll.insertAtEnd(55);
//        cll.traversalCLL(head);
//        System.out.println(cll.head.data);
//        System.out.println(cll.tail.data); //no tail update done since no tail(only head case)
//
//        head = cll.insertBeforePosition(35,4);
//        cll.traversalCLL(head);
//
//        head = cll.insertAfterValue(66,55);
//        cll.traversalCLL(head);
//
//        head = cll.deleteFromHead(head);
//        cll.traversalCLL(head);
//
//        head = cll.deleteFromEnd(head);
//        cll.traversalCLL(head);
//
//        head = cll.deleteFromPosition(head,0);
//        cll.traversalCLL(head);
//
//        head = cll.deleteByValue(head,40);
//        cll.traversalCLL(head);







        //coding exercises:
//        int ans = cll.countNodes(head);
//        System.out.println(ans);

//        int ans = cll.searchNode(head, 7);
//        System.out.println(ans);

        head = cll.convertCLLtoSLL(head);
        cll.traverseLL(); //should use traverseLinkedList because we converted it



    }
}
