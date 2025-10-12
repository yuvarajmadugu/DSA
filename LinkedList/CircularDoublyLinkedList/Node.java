package DSA.LinkedList.CircularDoublyLinkedList;

public class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data){
        this.prev = null;
        this.data = data;
        this.next = null;
    }
    public Node(int data, Node next, Node prev){
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
