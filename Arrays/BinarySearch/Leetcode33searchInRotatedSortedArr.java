package DSA.Arrays.BinarySearch;

public class Leetcode33searchInRotatedSortedArr {
    //search and element in a rotated sorted array (having no duplicated):
    static int searchInRotatedSortedArray(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == x){
                return mid;
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
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,1,2,3};
        int x = 2; //o/p index of 2 is 6
        System.out.println(searchInRotatedSortedArray(arr,x));

    }
}
