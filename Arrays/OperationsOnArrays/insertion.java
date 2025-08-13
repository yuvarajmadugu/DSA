package DSA.Arrays.OperationsOnArrays;

import java.util.Arrays;

public class insertion {

////         insert an element in the beginning of an array:
////    to insert at the beginning all the other elements should shift all elements to the right
    static void insertAtBeginning(int[] arr, int x){
        try {
            int count = 0;
            for (int num : arr) {
                if (num != 0) {
                    count++;
                } else { break; }
            }
            for (int i = count; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = x;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        System.out.println("Modified array: " + Arrays.toString(arr));
    }


////        insert an element in the end of an array:
////    to insert at the end no need to shift anything just count no.of elements in array and where zero's start there insert value
    static void insertAtEnd(int[] arr, int x){
        try{
            int count = 0;
            for(int num:arr){
                if(num != 0){
                    count++;
                }else { break; }
            }
            arr[count] = x;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        System.out.println("Modified array: " + Arrays.toString(arr));
    }


////        insert an element in the array at a specific position:
////    to insert an element in the middle one must move its forward/right corresponding to the right to make place then insert the value
    static void insertAtSpecificPosition(int[] arr,int position, int insertValue){
        try {
           int count = 0;
           for(int num:arr) {
               if (num != 0) {
                   count++;
               } else {
                   break;
               }
           }
           if(position<0 || position>count+1){
               System.out.println("Position is not valid.");
               return;
           }else {
               for(int i=count; i>=position; i--){
                    arr[i] = arr[i-1];
               }
               arr[position-1] = insertValue;
               count++;
           }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        System.out.println("Modified array: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{10,5,7,20,0,0,0,0,0,0};
        insertAtBeginning(arr1,33);

//        int[] arr2 = {1,2,3,4,5,6,7,8,0}; // empty slot 0 must be present in the insert position
//        int insertValue = 9;
//        insertAtEnd(arr2, insertValue);

//        int[] arr3 = {1,2,0,4,5,0,0,0,0};
//        insertAtSpecificPosition(arr3,3,3);



    }



}
