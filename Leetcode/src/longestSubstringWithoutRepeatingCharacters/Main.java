package longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

/*
    https://leetcode.com/problems/longest-substring-without-repeating-characters
    Topics
    Staff, Hash Table, String, Sliding Window
 */
public class Main {
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
        if(s.length() == 1) return 1;

        Set<Character> map = new HashSet<>();
        int max = 0, tmp = 0;
        int left = 0;
        int right = 1;
        map.add(s.charAt(left));

        while(right < s.length()){
            if(map.contains(s.charAt(right))) {
                while (map.contains(s.charAt(right))) {
                    map.remove(s.charAt(left));
                    left++;
                }
            }else{
                map.add(s.charAt(right));
                tmp = map.size();
                max = Math.max(max, tmp);
                right++;
            }
        }
        max = Math.max(max, tmp);

        return max;
    }
}
