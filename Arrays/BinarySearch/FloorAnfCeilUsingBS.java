package DSA.Arrays.BinarySearch;

import java.util.Arrays;

public class FloorAnfCeilUsingBS {
//floor = largest num <= target num
//ceil = smallest num >= target num

//              Binary Search:
    static int findFloor(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int floor = -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] == x){
                //floor = arr[mid];
                return floor;
            } else if (arr[mid] < x) {
                floor = arr[mid];
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return floor;
    }

    static int findCeil(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int Ceil = -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] == x){
                //Ceil = arr[mid];
                return Ceil;
            } else if (arr[mid] > x) {
                Ceil = arr[mid];
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return Ceil;
    }


    static int[] findFloorAndCeil(int[] arr, int x) {
        int[] result = {-1, -1};
        int floor;
        int ceil;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                floor = arr[mid];
                ceil = arr[mid];
                result[0] = floor;
                result[1] = ceil;
                return result;
            } else if (arr[mid] > x) {
                ceil = arr[mid];
                high = mid - 1;
                result[1] = ceil;
            } else if (arr[mid] < x) {
                floor = arr[mid];
                low = mid + 1;
                result[0] = floor;
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
