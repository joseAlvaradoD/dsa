package threeClosestSum;

/*
    https://leetcode.com/problems/3sum-closest/
    Array, Two Pointers, Sorting
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println("****************************");
        System.out.println(solution.threeSumClosest(new int[]{0,0,0}, 0));
        System.out.println("****************************");
        System.out.println(solution.threeSumClosest(new int[]{10,20,30,40,50,60,70,80,90}, 1));
        System.out.println("****************************");
        System.out.println(solution.threeSumClosest(new int[]{2,5,6,7}, 16));
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = 0;
        int difference=Integer.MAX_VALUE;

        for(int i = 0; i < nums.length-1; i++){
            int left = i+1;
            int right = nums.length-1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == target) return sum;

                if(Math.abs(sum - target) < difference){
                    difference = Math.abs(sum - target);
                    closestSum = sum;
                }

                if(sum < target){
                    left++;
                }else{
                    right--;
                }
            }

        }

        return closestSum;
    }
}
