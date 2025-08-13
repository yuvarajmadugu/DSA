package DSA.Arrays;

import java.util.Scanner;

public class TwoDimArrays {
    //simple taking input matrix 2D Array from user and printing
    public static void main(String[] args) {
//        double[][] matrix = new double[][] {{1,2,3}, {4,5,6}};
        double[][] matrix = new double[2][3];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 2D Array elements: ");
        for(int i=0; i<2; i++){ //rows
            for(int j=0; j<3; j++){ //cols
                matrix[i][j] = sc.nextDouble();
            }
        }
        System.out.println("Printing the elements entered by user: ");
        //for loop:
//        for(int i=0; i<2; i++){ //rows
//            for(int j=0; j<3; j++){
//                System.out.print(matrix[i][j] +"  ");
//            }
//            System.out.println();
//        }

        //for each loop - enhanced:
        for(double[] elements: matrix){
            for(double x: elements){
                System.out.print(x +"  ");
            }
            System.out.println();
        }
    }
}
