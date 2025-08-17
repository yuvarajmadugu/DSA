package DSA.Arrays.BinarySearch;

import java.util.Arrays;

public class Leetcode189RotateArray {
    // i=loop/array index arr[0] likewise
    // k=position mentioned to rotate (here its 3)
    // n=length of the array
    //here we are using a temp array as auxilary space therefore SC=O(n)

//    static void rotateArray(int[]arr, int k){
//        //approach using another array naming temp which is an auxilary space:
//        int n=arr.length;
//        int[] temp = new int[n];
//        for(int i=0; i< arr.length; i++){
//            temp[(i+k)%n] = arr[i];
//        }
//        for(int i=0; i< arr.length; i++){
//            arr[i] = temp[i];
//        }
//    }


// using O(1) space complexity and no auxilary space rotating in the same array:
    static void reverseArray(int[] arr,int start, int end){
        //two pointer approach:
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void rotateArray(int[] arr, int k){
        int n= arr.length;
        k = k%n; //8=8%7 i.e 1, if k>arr.length it need not tobe rotated that many times as after the arr.length rotations the array is same as the initial array
        reverseArray(arr,0,n-1);
        reverseArray(arr,0,k-1);
        reverseArray(arr,k,n-1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k=3;
        rotateArray(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}
