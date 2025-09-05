package DSA.Arrays.Leetcode;

import java.util.Arrays;

public class LC27RemoveElement {
    static int removeElements(int[] nums, int val){
        int k=0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,2 };
        int val = 2;
        System.out.println("No.of different elements in the array rather than val provided: "+removeElements(nums, val));
    }
}
