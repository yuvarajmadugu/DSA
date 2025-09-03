package DSA.Arrays.TwoDimArray;

import java.util.Arrays;

public class SearchRowWiseSortedArray {
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

    static int[] searchSortedRowMatrix(int[][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0; i<row; i++){
            if(target >= matrix[i][0] && target <= matrix[i][col-1]) {
                int index = binarySearch(matrix[i], target);
                if (index >= 0) {
                    return new int[]{i, index};
                }
            }
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args) {
        int[][] matrix = { {1,4,7,10}, {23,41,56,60}, {6,16,45,100} };
        int[] result = searchSortedRowMatrix(matrix,45);
        System.out.println(Arrays.toString(result));
    }
}



