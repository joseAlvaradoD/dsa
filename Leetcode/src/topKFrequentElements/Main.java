package topKFrequentElements;

import java.util.*;

/*
    https://leetcode.com/problems/top-k-frequent-elements
    Array
    Hash Table
    Divide and Conquer
    Sorting
    Heap (Priority Queue)
    Bucket Sort
    Counting
    Quickselect
 */

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        utils.Arrays.print(solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2));//1,2
        utils.Arrays.print(solution.topKFrequent(new int[]{1}, 1));//1
        utils.Arrays.print(solution.topKFrequent(new int[]{1,2,1,2,1,2,3,1,3,2}, 2));//1,2
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length+1];
        int[] res = new int[k];

        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entrySet: count.entrySet()){
            if(freq[entrySet.getValue()] == null)
                freq[entrySet.getValue()]=new ArrayList<>();
            freq[entrySet.getValue()].add(entrySet.getKey());
        }

        int index = 0;
        for(int i = freq.length-1; i >= 0 && index < k; i--){
            if(freq[i] != null)
                for(int n : freq[i]){
                    res[index++] = n;
                    if(index == k) break;

                }
        }

        return res;
    }
}