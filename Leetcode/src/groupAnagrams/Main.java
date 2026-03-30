package groupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    https://leetcode.com/problems/group-anagrams/
    Array
    Hash Table
    String
    Sorting
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        //[["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(solution.groupAnagrams(new String[]{}));//[[]]
        System.out.println(solution.groupAnagrams(new String[]{"a"}));
        //[["a"]]
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs){
            char[] chars = new char[26];
            for (char ch: str.toCharArray()){
                chars[ch - 'a']++;
            }
            String key = new String(chars);
            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(str);
        }

        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }
}
