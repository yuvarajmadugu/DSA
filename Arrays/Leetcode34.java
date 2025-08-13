package DSA.Arrays;

import java.util.Arrays;

public class Leetcode34 {
////    Brute force - Linear Search approach:
//    static int[] FirstnLastElementInAnArray(int[] arr, int target){
//        int[] result = {-1, -1};
//        for(int i=0; i< arr.length; i++){
//            if(arr[i] == target){
//                if(result[0] == -1){
//                    result[0] = i;
//                }
//                result[1] = i;
//            }
//        }
//        System.out.println(Arrays.toString(result));
//        return result;
//    }


////    Binary search:
//// first and last position checking:
//    static int firstPosition(int[] arr, int x){
//        int low = 0, high = arr.length-1;
//        int first = -1;
//        while(low<=high){
//            int mid = low+(high-low)/2;
//            if(arr[mid] == x){
//                first = mid; // if mid == target it may be our answer
//                high = mid-1; //coz first occurrence may lay in left side
//            } else if (arr[mid]>x) {
//                high = mid-1;
//            } else {
//                low = mid+1;
//            }
//        }
//        return first;
//    }
//    static int lastPosition(int[] arr, int x){
//        int low = 0, high = arr.length-1;
//        int last = -1;
//        while(low<=high){
//            int mid = low+(high-low)/2;
//            if(arr[mid] == x){
//                last = mid; // if mid == target it may be our answer
//                low = mid+1; //coz first occurrence may lay in left side
//            } else if (arr[mid]>x) {
//                high = mid-1;
//            } else {
//                low = mid+1;
//            }
//        }
//        return last;
//    }
//    static int[] firstAndLastPosition(int[] arr, int target){
//        int first = firstPosition(arr, target);
//        if(first == -1){
//            return new int[]{-1, -1};
//        }
//        return new int[]{first, lastPosition(arr, target)};
//    }

            ////for above methods use this in the psvm{}:
//    static int[] searchRange(int[] nums, int target) {
//        int first = firstPosition(nums, target);
//            if(first == -1){
//                return new int[]{-1, -1};
//            }
//        return new int[]{first, lastPosition(nums, target)};
//    }


//// finding first and last position using lowerbound and upperbound:
static int lowerBound(int[] arr, int x) {
    int low = 0;
    int high = arr.length-1;
    if(x > arr[arr.length-1]){
        return -1;
    }
    while(low<=high){
        int mid = low+(high-low)/2;
        if(arr[mid] >= x){
            high = mid-1;
        } else{
            low = mid+1;
        }
    }
    return low;
}
    static int upperBound(int[] arr, int x) {
        int low = 0;
        int high = arr.length-1;
        int ub = arr.length;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] > x){
                ub = mid;
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return ub;
    }

    static int[] firstAndLastPosition(int[] arr, int x){
    int[] result = {-1, -1};

    int lb= lowerBound(arr,x);
    if(lb == arr.length || arr[lb] != x){
        return result;
    }

    int ub = upperBound(arr,x);
    result[0] = lb;
    result[1] = ub-1;

    return result;
    }


    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 8;

//        int[] result = firstAndLastPosition(arr, target);
//        System.out.println(Arrays.toString(result));

        int[] result = firstAndLastPosition(arr, target);
        System.out.println(Arrays.toString(result));


        
    }

}
