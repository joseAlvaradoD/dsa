package longestConsecutiveSequence;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    https://leetcode.com/problems/longest-consecutive-sequence/
    Array, Hash Table, Union-Find
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutiveSequence(new int[]{2,20,4,10,3,4,5}));//4
        System.out.println(solution.longestConsecutiveSequence(new int[]{0,3,7,2,5,8,4,6,0,1}));//9
        System.out.println(solution.longestConsecutiveSequence(new int[]{1,0,1,2}));//3
    }
}
class Solution{
    int longestConsecutiveSequence(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for(int num: nums){
            set.add(num);
            min = Math.min(min, num);
        };
        int count = 1;
        for(int i=1; i<set.size(); i++){
            if(set.contains(++min)){
                count++;
            }else{
                ans = Math.max(ans, count);
                count = 1;
                while(!set.contains(++min)){}
            }
        }

        ans = Math.max(ans, count);

        return ans;
    }
}
