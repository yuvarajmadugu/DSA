package DSA.Arrays;

public class Leetcode35 {
    static int searchInsertPosition(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int pos = arr.length;

        while(low<high){
            int mid = low+(high-low)/2;
            if(arr[mid] == x){
                return mid;
            } else if (arr[mid]>x) {
                pos = mid;
                high = mid-1;  //moving towards the left of the array
            } else {
                low = mid+1;   //moving towards the right of the array
            }
        }
        return pos; //or return low;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7};
        int target = 6;
        int position = searchInsertPosition(arr,target);
        System.out.println(position);
    }
}
