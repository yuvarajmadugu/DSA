package DSA.Arrays.LinearSearchTypes;

public class SentinalLS {
////    add the target element to the end of the dummy array(not replace or swap)
////    just to skip no.of iterations and comparing only arr[i] == x
////     avoid checking array bound in each iteration
    static int sentinalls(int[] arr, int x){
        int n = arr.length;

        // Step 1: Save the last element
        int last = arr[n-1];

        // Step 2: Place target at the last position
        arr[n-1] = x;

        // Step 3: Start scanning without checking bounds
        int i = 0;
        while(arr[i] != x){
            i++;
        }

        // Step 4: Restore the last element
        arr[n-1] = last;

        if(i<n-1 || arr[n-1] == x) {
            return i; // Found in the real array
        }
        return -1; //element not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int target = 5;
        int result = sentinalls(arr, target);
        if (result != -1) {
            System.out.println("Element in array found at index: " + result);
        } else {
            System.out.println("Element not found in array");
        }
    }
}
