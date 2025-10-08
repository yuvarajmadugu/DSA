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
    Node insertBeforePosition(int data, int pos){
        if(pos <= 0){
            System.out.println("Position invalid.Can not insert");
            return head;
        }
        if(pos == 1){
            return insertAtBeginning(data);
        }
        Node newNode = new Node(data);
        Node temp = head;
        int currentPos = 1;
        while (temp != null) {
            if (currentPos == pos) {
                break;
            }
            temp = temp.next;
            currentPos++;
        }
        if (temp == null){
            System.out.println("Position invalid, can not insert.");
            return head;
        }
        Node prevNode;
        prevNode = temp.prev;
        newNode.next = temp;
        temp.prev = newNode;
        newNode.prev = prevNode;
        prevNode.next = newNode;
        size++;
        return head;
    }
    Node insertAfterValue(int data, int value){
        if(head == null){
            System.out.println("No such value exist cant insert.");
            return head;
        }
        Node newNode=new Node(data);
        Node temp = head;
        while(temp != null && temp.data != value){
            temp = temp.next;
        }
        if (temp == null){
            System.out.println("No such value exist in the list cant insert.");
            return head;
        }
        Node nextNode = temp.next;
        newNode.next = nextNode;
        newNode.prev = temp;
        temp.next = newNode;
        if(nextNode != null){
            nextNode.prev = newNode;
        }
        size++;
        return head;
    }
    //Print in reverse order: Reverse DoublyLL
    void reverseTraverseDLL(Node head){
        Node temp = head;
        if(head == null){
            System.out.println("List is empty.");
        }else {
            //traversal to end of the list
            while(temp.next != null){
                temp = temp.next;
            }
        }
        //printing from the end of the list
        while (temp != null){
            System.out.print(temp.data +" ");
            temp = temp.prev;
        }
    }

    Node deleteFromBeginning(){
        if(head == null){
            System.out.println("List is empty, can not delete.");
            return head;
        }
        if (head.next == null){
            head = null;
            tail = null;
            size--;
            return head;
        }
        Node prevNode;
        prevNode = head;
        head = prevNode.next;
        head.prev = null;
        prevNode.next = null;
        size--;
        return head;
    }
    Node deleteFromEnd(){
        if (head == null){
            System.out.println("List is empty, can not delete.");
            return head;
        }
        if(head.next == null){
            head = null;
            tail = null;
            size--;
            return head;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        Node prevNode;
        prevNode = temp.prev;
        prevNode.next = null;
        temp.prev = null;
        size--;
        return head;
    }
    Node deleteFromPosition(int pos){
        if (head == null){
            System.out.println("List is empty, can not delete.");
            return head;
        }
        if (pos <= 0){
            System.out.println("Position is not valid.");
            return head;
        }
        if(pos == 1){
            return deleteFromBeginning();
        }
        Node temp = head;
        int currentPos = 1;
        while(temp != null){
            if (currentPos == pos){
                break;
            }
            temp = temp.next;
            currentPos++;
        }
        if(temp == null){
            System.out.println("Given position is in valid, can not delete.");
            return head;
        }
        Node prevNode, nextNode;
        prevNode = temp.prev;
        nextNode = temp.next;
        prevNode.next = temp.next;
        if(nextNode != null){
            nextNode.prev = prevNode;
            temp.next = null;
        }
        temp.prev = null;
        size--;
        return head;
    }
    Node deleteByValue(int value){
        if (head == null){
            System.out.println("List is empty, can not delete.");
            return head;
        }
        if (head.data == value){
            return deleteFromBeginning();
        }
        Node temp= head;
        while (temp != null && temp.data != value){
            temp = temp.next;
        }
        if (temp==null){
            System.out.println("No such value exists, cant delete.");
            return head;
        }
        Node prevNode = temp.prev;
        prevNode.next = temp.next;
        if (temp.next != null){
            temp.next.prev = prevNode;
            temp.next = null;
        }
        temp.prev = null;
        size--;
        return head;
    }

    //coding exercises:
    int countNodes(Node head){
        if(head == null){
            return 0;
        }
        int count = 0;
        Node temp = head;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    boolean searchDLL(Node head, int value){
        if (head == null){
            return false;
        }
        //case1 : we have only head
        /*Node temp = head;
        while (temp != null){
            if(temp.data == value){
                return true;
            }
            temp = temp.next;
        }
        return false;
         */
        //case2 : we have both head and tail
        while (head != tail && head.prev != tail){
            if(head.data == value || tail.data == value){
                return true;
            }
            head = head.next;
            tail = tail.prev;
        }
        if(head == tail && head.data == value){
            return true;
        }
        return false;
    }
    Node reverseDLL(Node head){
        if (head == null){
            return head;
        }
        Node temp = head;
        Node currentNode = null;
        while (temp != null){
            currentNode = temp.prev;
            temp.prev = temp.next;
            temp.next = currentNode;
            temp = temp.prev;
        }
        head = currentNode.prev;
        return head;
    }
    boolean isPalindrome(Node head){
        if (head == null){
            return false;
        }
        while (head.prev != tail && head != tail){
            if (head.data != tail.data){
                return false;
            }
            head = head.next;
            tail = tail.prev;
        }
        return true;
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

//        head = dll.insertBeforePosition(22,8);
//        dll.traverseDLL(head);

//        head = dll.insertAfterValue(44,70);
//        dll.traverseDLL(head);

//        dll.reverseTraverseDLL(head);

//        head = dll.deleteFromBeginning();
//        dll.traverseDLL(head);

//        head = dll.deleteFromEnd();
//        dll.traverseDLL(head);

//        head = dll.deleteFromPosition(0);
//        dll.traverseDLL(head);

//        head = dll.deleteByValue(750);
//        dll.traverseDLL(head);







        //coding exercises:
//        int ans = dll.countNodes(head);
//        System.out.println(ans);

//        boolean ans = dll.searchDLL(head,20);
//        System.out.println(ans);

//        head = dll.reverseDLL(head);
//        dll.traverseDLL(head);

        boolean ans = dll.isPalindrome(head);
        System.out.println(ans);




    }
}
