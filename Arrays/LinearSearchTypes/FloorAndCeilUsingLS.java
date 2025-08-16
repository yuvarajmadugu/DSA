package DSA.Arrays.LinearSearchTypes;

import java.util.Arrays;

public class FloorAndCeilUsingLS {
//floor = largest num <= target num
//ceil = smallest num >= target num

//                     Linear Search:
    static int findFloor(int[] arr, int x){
        int floor = -1;
        for(int i=0; i< arr.length-1; i++){
            if(arr[i] <= x){
                floor = arr[i];
            } else{
                break;
            }
        }
        return floor;
    }

    static int findCeil(int[] arr, int x){
        int ceil = -1;
        for(int i=0; i< arr.length-1; i++) {
        if(arr[i] >= x){
                ceil = arr[i];
                break;
            }
        }
        return ceil;
    }

    static int[] findFloorAndCeil(int[] arr, int x){
        int[] result = {-1,-1};
        int floor;
        int ceil;
        for(int i=0; i< arr.length-1; i++){
            if(arr[i] == x){
                floor = arr[i];
                ceil = arr[i];
                result[0] = floor;
                result[1] = ceil;
                return result;
            }
            else if(arr[i] < x){
                floor = arr[i];
                result[0] = floor;
            } else {
                ceil = arr[i];
                result[1] = ceil;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,10,15,19,24,28,32,37,41,46,51};
        int targetnum = 9;
        int answer = findFloor(arr, targetnum);
        int answer2 = findCeil(arr,targetnum);
        int[] answer3 = findFloorAndCeil(arr, targetnum);
        if(answer != -1) {
            System.out.println("Floor of "+targetnum+" is "+answer);
            System.out.println("Ceil of "+targetnum+" is "+answer2);
            System.out.println("Floor and ceil of "+targetnum+" is "+ Arrays.toString(answer3));
        }else {
            System.out.println("None");
        }
    }
}
