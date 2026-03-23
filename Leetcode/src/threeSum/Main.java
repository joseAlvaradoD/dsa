package threeSum;

import java.util.*;

/*
    https://leetcode.com/problems/3sum/
    Array, Two Pointers, Sorting
 */

public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(solution.threeSum(new int[]{0,1,1}));
        System.out.println(solution.threeSum(new int[]{0,0,0}));
        System.out.println(solution.threeSum(new int[]{0,0,0,0}));
    }

}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for(int index = 0; index < n-1; index++){
            if (index > 0 && nums[index] == nums[index-1]) {
                continue;
            }

            int right = n-1;
            int left = index+1;

            while(left < right){
                int total = nums[index] + nums[left] + nums[right];

                if(total == 0){
                    ans.add(Arrays.asList(nums[index], nums[left], nums[right]));

                    left++;

                    while(nums[left] == nums[left-1] && left < right){
                        left++;
                    }
                }else if(total > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }

        return ans;
    }
}