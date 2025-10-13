package DSA.LinkedList.Leetcode;

import DSA.LinkedList.Node;

public class LC19RemoveNthNodeFromEnd {

    private Node head;
    private Node tail;
    private int size;

    Node insertAtBeginning(int data){
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
        if(tail == null){
            tail = newNode;
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
        System.out.println("End");
    }

    //Remove nth element fom the end: (n can only be within the size)
                        //Approach 1: Bruteforce
    /*Node removeNthNodeFromEnd(Node head, int n){
        Node temp = head;
        int size = 0;
        while (temp != null){
            size++;
            temp = temp.next;
        }
        if(size == n){
            head = head.next;
            return head;
        }
        int pos = size-n;
        temp = head;
        int i=1;
        while (i < pos){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        return head;
    }
     */

                        //Approach 2: Optimal(Two Pointer approach)
    Node removeNthNodeFromEnd(Node head, int n){
        Node slow = head;
        Node fast = head;
        //here n is number of persons/steps that fast should be ahead from slow (simply position)
        for(int i=0; i<n; i++){
            fast = fast.next;
        }
        if(fast == null){
            head = head.next;
            return head;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node head = null;
        LC19RemoveNthNodeFromEnd obj = new LC19RemoveNthNodeFromEnd();

        head = obj.insertAtBeginning(10);
        head = obj.insertAtBeginning(20);
        head = obj.insertAtBeginning(30);
        head = obj.insertAtBeginning(40);
        head = obj.insertAtBeginning(50);
        head = obj.insertAtBeginning(60);
        head = obj.insertAtBeginning(70);
        obj.traverseLL(head);

        head = obj.removeNthNodeFromEnd(head,7);
        obj.traverseLL(head);

    }
}
