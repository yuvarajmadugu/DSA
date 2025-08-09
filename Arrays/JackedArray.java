package DSA.Arrays;

import java.util.Arrays;

public class JackedArray {
    public static void main(String[] args) {
        int[][] jackedArrayDemo = new int[3][];
        jackedArrayDemo[0] = new int[3]; //1st row has 3 col values
        jackedArrayDemo[1] = new int[4]; //2nd row has 4 col values
        jackedArrayDemo[2] = new int[1]; //3rd row has 1 col value


        int[][] jackedArray = {
                {1,2,3},
                {4,5,6,7},
                {8}
        };

        for(int i=0; i<jackedArray.length; i++){ //i = row
            for(int j=0; j<jackedArray[i].length; j++){ //j = col
                System.out.print(Arrays.deepToString(jackedArray) +"  ");
            }
            System.out.println();
        }
                //or
        System.out.println(Arrays.deepToString(jackedArray));

    }
}
