package DSA.Arrays.BinarySearch;

public class Leetcode81searchInRotatedArray2 {
    //search and element in a rotated sorted array with distinct elements that is with duplicates in the array:
    static boolean searchInRotatedSortedArray(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == x){
                return true;
            }
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low++;
                high--;
                continue; //continue goes again from while(low<high) to current line
            }

            //if left part of array is sorted:
            if(arr[low] <= arr[mid]){
                if(x>=arr[low] && x<arr[mid]){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }
            //if right part of array is sorted:
            else {
                if(x>arr[mid] && x<=arr[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,6,7,8,1,2,3,3,3};
        int target = 3;
        System.out.println(searchInRotatedSortedArray(arr,target));
    }
}
