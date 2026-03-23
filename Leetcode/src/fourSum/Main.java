package fourSum;

/*
    https://leetcode.com/problems/4sum
    Array
    Two Pointers
    Sorting
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
        //System.out.println(solution.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        //System.out.println(solution.fourSum(new int[]{2,2,2,2,2}, 8));
        //System.out.println(solution.fourSum(new int[]{-3,-1,0,2,4,5}, 2));
        //System.out.println(solution.fourSum(new int[]{-1,0,1,2,-1,-4}, -1));
        //System.out.println(solution.fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
    }
}
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < nums.length-1; i++){
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            for(int j = i+1; j < nums.length-1; j++){
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }

                int left = j+1;
                int right = nums.length-1;

                while(left < right){
                    long total = (long)nums[i] + nums[left] + nums[right] + nums[j];
                    if(total == target){
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right], nums[j]));
                        left++;
                        right--;
                        while(nums[left] == nums[left-1] && left < right){
                            left++;
                        }
                        while(nums[right] == nums[right+1] && left < right){
                            right--;
                        }
                    }else if(total < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
