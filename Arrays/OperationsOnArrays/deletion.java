package DSA.Arrays.OperationsOnArrays;

import java.util.Arrays;

public class deletion {
////        delete from the beginning of an array:
////    after deletion of an array from the beginning all the other elements must move to its previous index
//    static void deleteFromBeginning(int[] arr){
//        try{
//            int count = 0;
//            for(int num:arr){
//                if(num != 0){
//                    count++;
//                }else { break; }
//            }
//            for(int i=0; i< arr.length; i++){
//                arr[i] = arr[i+1];
//            }
//        }catch (ArrayIndexOutOfBoundsException e){
//            System.out.println(e);
//        }
//        System.out.println("Modified array: "+ Arrays.toString(arr));
//    }

////        delete from the end of an array:
////    count the size of ann array and delete the last element in the array
//    static void deleteFromEnd(int[] arr){
//        try{
//            int count = 0;
//            for(int num: arr){
//                if(num != 0){
//                    count++;
//                }
//            }
//            arr[count-1] = 0;
//        }catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println(e);
//        }
//        System.out.println("Modified array: "+ Arrays.toString(arr));
//    }

////        delete from a specific position of an array
////    after deletion from a specific position then move all the right side elements to the left to fill the gap
    static void deleteFromSpecificPostion(int[] arr, int pos){
        try{
            int count = 0;
            for(int num: arr){
                if(num != 0){
                    count++;
                }else {break;}
            }
            if(pos<=0 || pos>count){
                System.out.println("Position is invalid");
            }
            else{
                for(int i=pos-1; i<count-1; i++){
                    arr[i] = arr[i+1];
                }
                arr[count-1] = 0;
                count--;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,0,0,0,0,0};
//        deleteFromBeginning(arr);

//        int[] arr2 = {1,2,3,4,5,6,0,0,0,0};
//        deleteFromEnd(arr2);

        int[] arr3 = {1,2,3,4,5,6,7,8};
        deleteFromSpecificPostion(arr3,3);
    }

}
