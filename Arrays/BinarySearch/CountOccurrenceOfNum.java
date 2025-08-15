package DSA.Arrays.BinarySearch;

public class CountOccurrenceOfNum {
    
    static int searchPosition(int[] arr, int x, boolean findPosition){
        int low = 0, high = arr.length-1, pos = -1;

        while (low <= high){
            int mid = low+(high-low)/2;
            if (arr[mid] == x) {
                pos = mid;  // store the found position
                if (findPosition) {
                    high = mid - 1; // keep searching left for first occurrence
                } else {
                    low = mid + 1; // keep searching right for last occurrence
                }
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return pos;
    }

    static int[] firstAndLastPosition(int[] arr, int x){
        int[] result = {-1,-1};
        int first = searchPosition(arr, x, true);
        if(first == -1){
            return result;
        }
        int last = searchPosition(arr, x, false);
        result[0] = first;
        result[1] = last;
        return result;
    }

    static int countOccurrence(int[] arr, int target){
        int count = 0;
        int[] answer = firstAndLastPosition(arr,target);
        if(answer[0] == -1){
            return 0;
        }
        count = (answer[1] - answer[0])+1;
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,3,3,3,3,5,7};
        int target = 3;
        int result = countOccurrence(arr, target);
        System.out.println(result);
    }
}


