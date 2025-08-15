package DSA.Arrays.BinarySearch;

public class OrderAgnosticBS {
////    first determine if array is ascending or descending order:
////    adjust comparision logic based on arr order: if one doesn't know the order then comes
////            orderAgnostic Binary search:

    static int orderAgnosticBinarySearch(int [] arr, int x){
        int low = 0;
        int high = arr.length-1;
        boolean isAscending = false;
        if(arr[low] < arr[high]){
            isAscending = true;
        }

        while(low < high){
            int mid = low+ (high-low)/2;
            if(x == arr[mid]){
                return mid;
            }
            if(isAscending){
                if(x > arr[mid]){
                    low = mid+1;
                }
                else if(x < arr[mid]){
                    high = mid-1;
                }
            }
            else {
                if(x > arr[mid]){
                    high = mid-1;
                }
                else if (x < arr[mid]) {
                    low = mid+1;
                }
            }
        }
      return -1;
    }

    public static void main(String[] args) {

        // ascending order:
//        int[] arr = {1,2,3,4,5,6};
//        int key = 2;
//        int result = orderAgnosticBinarySearch(arr, key);
//        if( result != -1){
//            System.out.println("Element found at "+result);
//        } else{
//            System.out.println("Element not found");
//        }

        //descending order:
        int[] arr = {6,5,4,3,2,1};
        int key = 2;
        int result = orderAgnosticBinarySearch(arr, key);
        if( result != -1){
            System.out.println("Element found at "+result);
        }else{
            System.out.println("Element not found");
        }
    }
}
