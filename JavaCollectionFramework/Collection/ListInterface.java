package DSA.JavaCollectionFramework.Collection;

import java.util.ArrayList;
import java.util.List;

public class ListInterface {
    public static void main(String[] args) {
        //list is ordered and duplicates allowed, 0 based index:

        List<String> list = new ArrayList<>();
        list.add("A");  // index-based add
        list.add("B");
        list.add("A");  // duplicate allowed
        list.add(1, "C"); // insert at index
        System.out.println(list);

        list.set(2, "X");      // update element at index
        System.out.println(list.get(2)); // access by index

        list.remove(1); // remove by index
        System.out.println(list);

        System.out.println("Index of A: " + list.indexOf("A"));
        System.out.println("Last index of A: " + list.lastIndexOf("A"));

    }
}
