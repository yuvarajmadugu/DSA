package DSA.Arrays.BinarySearch;

public class UpperBound {

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

    public static void main(String[] args) {
        int[] arr = {2,5,7,15,15,15,22,25,50};
        int key = 2;
        int result = upperBound(arr, key);
        System.out.println("Upper bound of "+key+" is "+result);
    }
}
