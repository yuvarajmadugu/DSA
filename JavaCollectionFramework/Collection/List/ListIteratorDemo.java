package DSA.JavaCollectionFramework.Collection.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("X","Y","Z"));

        ListIterator<String> li = list.listIterator();

        while(li.hasNext()) {
            System.out.println("Next: " + li.next());
        }

        while(li.hasPrevious()) {
            System.out.println("Previous: " + li.previous());
        }

        li.add("NEW"); // add during iteration,
        System.out.println(list);
    }
}
