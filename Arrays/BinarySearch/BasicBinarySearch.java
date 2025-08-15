package DSA.Arrays.BinarySearch;

public class BasicBinarySearch {
////    in binary search the elements in the array must be in ascending order:
////      if array elements is in descending order checkout comment instructions

    static int binarySearch(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            int mid = low+ (high-low)/2;
            if(x == arr[mid]){
                return mid;
            }
            else if (x > arr[mid]){ //if array is in ascending order follow as per comments:
                low = mid+1;        //high = mid-1;
            }
            else{
                high = mid-1;       //low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int key = 2;
        int result = binarySearch(arr, key);
        if( result != -1){
            System.out.println("Element found at "+result);
        }else{
            System.out.println("Element not found");
        }
    }
}



