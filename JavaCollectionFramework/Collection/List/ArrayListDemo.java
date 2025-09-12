package DSA.JavaCollectionFramework.Collection.List;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        //Dynamic Array Implementation of List, 0 based Index

        ArrayList<Integer> arr = new ArrayList<>(20);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(null);
        arr.addFirst(89);
        arr.addFirst(91); //0 based Index
        arr.remove(Integer.valueOf(30));
        System.out.println(arr.indexOf(20)); //returns index of element, if not available returns -1
        System.out.println(arr.add(90)); //true adds in the end of arraylist

        arr2.add(62);
        arr2.addAll(arr); // adds all elements of arr in arr2
        arr2.add(1,63);
        System.out.println(arr2.contains(63)); //element present or not
        System.out.println(arr2.containsAll(arr)); //contains all elements of arr or not
        System.out.println("Arr2: " +arr2);

        arr2.retainAll(arr);
        System.out.println(arr2); //all other except actual list = retain

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
