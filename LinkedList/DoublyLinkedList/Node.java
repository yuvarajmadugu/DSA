package DSA.LinkedList.DoublyLinkedList;

public class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data){
        this.prev = null;
        this.data = data;
        this.next = null;
    }
}
