package DSA.Arrays.TwoDimArray;

import java.util.Arrays;

public class SearchSortedArray {
    static int binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(target == arr[mid]){
                return mid;
            }else if (target > arr[mid]){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }

    static int[] searchSortedMatrix(int[][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;

        int rowLow = 0;
        int rowHigh = row-1;

        while(rowLow <= rowHigh){
            int rowMid = rowLow+(rowHigh-rowLow)/2;
            if(target >= matrix[rowMid][0] && target <= matrix[rowMid][col-1]){
                int index = binarySearch(matrix[rowMid], target);
                if(index >= 0){
                    return new int[]{rowMid, index};
                }
            }else if (target > matrix[rowMid][col-1]){
                rowLow = rowMid+1;
            }else {
                rowHigh = rowMid-1;
            }
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args) {
        int[][] matrix = { {5,7,9,10}, {12,15,18,30}, {31,32,34,35}, {38,40,41,45} };
        int[] result = searchSortedMatrix(matrix,32);
        System.out.println(Arrays.toString(result));
    }
}




