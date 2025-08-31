package DSA.JavaCollectionFramework.Collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionMethods {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        Collection<String> coll2 = new ArrayList<>();

        coll.add("Apple");   // add element
        coll.add("Banana");
        coll.add("Apple");   // duplicates allowed
        System.out.println("All elements in collection are: " +coll);

        coll2.add("Tomato");
        coll2.addAll(coll);
        System.out.println("Addall usage check: " +coll2);

        System.out.println("Checking presence of banana: " +coll.contains("Banana")); // check presence
        coll.remove("Banana");                       // remove element
        System.out.println("Size: " + coll.size());  // number of elements
        System.out.println("Is Empty? " + coll.isEmpty());
        System.out.println("Checking containsall method: " +coll2.containsAll(coll));

        coll.clear(); // remove all elements
        System.out.println("After clear method that removes all elements from the collection rechecking the collection: " +coll);
        System.out.println(coll2); //removal from coll will not erase data from coll2
    }
}
