package containsDuplicate;

/*
    https://leetcode.com/problems/contains-duplicate/
    Array
    Hash Table
    Sorting
 */

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(solution.containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(solution.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> duplicates = new HashSet<>();
        for(int num: nums){
            if(!duplicates.add(num)) return true;
        }
        return false;
    }
}
