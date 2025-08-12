package DSA.Arrays.LinearSearchTypes;

import java.util.Arrays;

public class MoveToFirstLS {
////    move the target element to the first in the linear search (swap of target and first element)
    static int movetofirstls(int[] arr, int x){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == x) {
                int index = i;
                if (i > 0) { // Only swap if not the first element
                    int temp = arr[i];
                    arr[i] = arr[0];
                    arr[0] = temp;
                }
                return index;
            }
        }
        return -1; //if not found
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int target = 5;
        int result = movetofirstls(arr, target);
        if (result != -1) {
            System.out.println("Element in array found at index: " +result);
            System.out.println("Modified array after swap: " + Arrays.toString(arr));
        }
        else {
            System.out.println("Element not found in array");
        }
    }
}
