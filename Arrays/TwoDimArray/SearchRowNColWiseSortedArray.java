package DSA.Arrays.TwoDimArray;

import java.util.Arrays;

public class SearchRowNColWiseSortedArray {
    static int[] searchRowColSortedArr(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i=0;
        int j=col-1;

        while(i<row && j>=0){
            if(target == matrix[i][j]){
                return new int[] {i,j};
            } else if (target < matrix[i][j]) {
                j--;
            }else {
                i++;
            }
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args) {
        int[][] matrix = { {5,15,25,30}, {7,16,26,31}, {10,18,28,35}, {20,21,30,40} };
        int[] result = searchRowColSortedArr(matrix,28);
        System.out.println(Arrays.toString(result));
    }
}
