package DSA.Arrays.LinearSearchTypes;

public class BiDirectionalLS {
    static int bidirectional(int[] arr, int x){
        int left = 0;
        int right = arr.length-1;

        while(left<right){
            if(arr[left] == x){
                return left;
            }
            if(arr[right] == x){
                return right;
            }
            left++;
            right--;
        }
        return -1; //element not found in the array
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int target = 4;
        int result = bidirectional(arr, target);
        if(result != -1) {
            System.out.println("Element in array found at index: " + result);
        } else {
            System.out.println("Element not found in array");
        }
    }
}