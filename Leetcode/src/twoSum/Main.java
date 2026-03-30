package twoSum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    https://leetcode.com/problems/two-sum
    Junior
    Array
    Hash Table
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        utils.Arrays.print(solution.twoSum(new int[]{2,7,11,15}, 9));
        utils.Arrays.print(solution.twoSum(new int[]{3,2,4}, 6));
        utils.Arrays.print(solution.twoSum(new int[]{3,3}, 6));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
