package DSA.LinkedList.Leetcode;

import DSA.LinkedList.Node;

public class LC0ConvertArrayToLL {
    Node head;

    Node convertArrToLL(int[] arr){
        head = new Node(arr[0]);
        Node temp = head;
        for (int i=1; i<arr.length; i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }
        return head;
    }
    void traverseLL(Node head){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public static void main(String[] args) {
        int[] arr = {10,3,2,4,5,9,1};
        Node head1;
        LC0ConvertArrayToLL obj = new LC0ConvertArrayToLL();

        head1 = obj.convertArrToLL(arr);
        obj.traverseLL(head1);

    }
}
