package DSA.JavaCollectionFramework.Collection.List;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        //Dynamic Array Implementation of List, 0 based Index

        ArrayList<Integer> arr = new ArrayList<>(20);
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.addFirst(89);
        arr.addFirst(91); //0 based Index
        System.out.println(arr.add(90)); //true adds in the end of arraylist

        System.out.println(arr.get(1)); // access element at index 1 - 89
        arr.set(1, 25); // update element
        arr.remove(0);  // remove element at index 0
        System.out.println("Size: " + arr.size()); //count start from 1 (or) lastIndex+1

        // Traversing
        for(Integer i : arr) {
            System.out.print(i +" ");
        }

    }
}
