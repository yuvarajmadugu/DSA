package DSA.Arrays;

public class TwoDimArrDemo {
    public static void main(String[] args) {
        int[][] matrix = new int[3][];

        int[][] matrix1 = new int[][]{
                {1,2,3},
                {4,5,6}
        };

        int[][] matrix2 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] matrix3 = new int[2][3];
        matrix3[0][0] = 1; // First row, first column
        matrix3[0][1] = 2;
        matrix3[0][2] = 3;

        matrix3[1][0] = 4;
        matrix3[1][1] = 5; // Second row, second column
        matrix3[1][2] = 6;
        System.out.println("Can be accessed as: "+matrix3[1][0]); //4


    }
}
