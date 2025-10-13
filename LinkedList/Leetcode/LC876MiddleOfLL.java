package DSA.LinkedList.Leetcode;

public class LC876MiddleOfLL {
    Node head = null;
    int size;

    Node insertAtBeginning(int data){
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
        if(head == null){
            head = newNode;
        }
        size++;
        return head;
    }
    void traverseLL(Node head){
        Node temp = head;
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        while (temp != null){
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
        System.out.println();
    }

    Node findMiddle(Node head){
        //Approach 1: Bruteforce
        /*int n=0;
        Node temp = head;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        int pos = (n/2)+1;
        temp = head;
        for(int i=1; i<pos; i++){
            temp = temp.next;
        }
        return temp;
         */



        //Approach 2: Optimal (Two-pointer approach)
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = null;
        LC876MiddleOfLL obj = new LC876MiddleOfLL();


        head = obj.insertAtBeginning(10);
        head = obj.insertAtBeginning(20);
        head = obj.insertAtBeginning(30);
        head = obj.insertAtBeginning(40);
        head = obj.insertAtBeginning(45);
        head = obj.insertAtBeginning(50);
        head = obj.insertAtBeginning(60);
        head = obj.insertAtBeginning(70);
        obj.traverseLL(head);

        head = obj.findMiddle(head);
        obj.traverseLL(head);


    }
}

