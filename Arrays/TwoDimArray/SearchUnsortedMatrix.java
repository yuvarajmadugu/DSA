package DSA.Arrays.TwoDimArray;

import java.util.Arrays;

public class SearchUnsortedMatrix {
    static int[] searchUnsortedMatrix(int[][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(target == matrix[i][j]){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1,-1}; 
    }

    public static void main(String[] args) {
        int[][] matrix = { {1,4,6,2}, {7,-3,89,90}, {12,10,45,78} };
        int[] ans = searchUnsortedMatrix(matrix, 89);

        System.out.println(Arrays.toString(ans));
    }
}



