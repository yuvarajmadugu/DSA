package DSA.Queue;

public class ArrayQueueUsingOnePtr {
    private int[] queue;
    private int rear;
    private int capacity;

    public ArrayQueueUsingOnePtr(int size){
        this.capacity = size;
        rear = -1;
        this.queue = new int[capacity];
        System.out.println("Queue has been created of size: "+size);
    }
}
