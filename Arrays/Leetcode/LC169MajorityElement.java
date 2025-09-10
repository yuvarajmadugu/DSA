package DSA.Arrays.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC169MajorityElement {
    static int findMajorityElementBruteforce(int[] nums){
        for(int i=0; i< nums.length; i++){
            int count=0;
            int majorityElement = nums[i];

            for(int j=0; j< nums.length; j++){
                if(majorityElement == nums[j]){
                    count++;
                }
            }

            if(count > nums.length/2){
                return majorityElement;
            }
        }
        return -1;
    }

    static int findMajorityElementUsingSortingandLoopCount(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);

        // Candidate from the middle
        int candidate = nums[(n - 1) / 2];

        // Validate with counting
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == candidate) {
                count++;
            }
        }

        if (count > n / 2) {
            return candidate;
        } else {
            return -1; // no majority element
        }
    }


    static int findMajorityElementUsingHashMap(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            int val = countMap.getOrDefault(nums[i],0);
            countMap.put(nums[i], val+1);
        }
        for (Map.Entry<Integer,Integer> it: countMap.entrySet()){
            if(it.getValue() > ((nums.length)/2)){
                return it.getKey();
            }
        }
        return -1;
    }


    static int findMajorityElementUsingMooreVoting(int[] nums){
        int majorityElement = 0;
        int vote = 0;

        for(int i=0; i<nums.length; i++){
            if(vote == 0){
                majorityElement = nums[i];
            }
            if(majorityElement == nums[i]){
                vote++;
            }else {
                vote--;
            }
        }
        return majorityElement;
    }


    public static void main(String[] args) {
        int[] arr = {2,2,0,3,1,3,2};

        //int result = findMajorityElementBruteforce(arr);

        //int result = findMajorityElementUsingSortingandLoopCount(arr);

        //int result = findMajorityElementUsingHashMap(arr);
//        if (result != -1) {
//            System.out.println("Majority element is: " + result);
//        } else {
//            System.out.println("No majority element found.");
//        }


        int result = findMajorityElementUsingMooreVoting(arr);
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(result == arr[i]) {
                count++;
            }
        }
        if(count > (arr.length/2)){
            System.out.println(result);
        }else {
            System.out.println("No Majority Element");
        }

    }
}