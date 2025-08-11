package DSA.Arrays.LinearSearchTypes;

public class BasicLinearSearch {

    static int LinearSearch(int[] arr, int x){
        for(int i=0; i< arr.length; i++){
            if(arr[i] == x){
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int target = 5;
        int result = LinearSearch(arr, target);
        if (result != -1) {
            System.out.println("Element in array found at index: " + result);
        } else {
            System.out.println("Element not found in array");
        }
    }
    
}


