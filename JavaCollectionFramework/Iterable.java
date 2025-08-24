package DSA.JavaCollectionFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterable {
    public static void main(String[] args) {
        List<Integer> list  = new ArrayList<>(List.of(1,2,3,45,5));
        System.out.println(list);

        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()){
            int num = itr.next();
            System.out.println(num);
        }
    }
}
