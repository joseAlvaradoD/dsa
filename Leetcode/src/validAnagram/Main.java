package validAnagram;

import java.util.Arrays;

/*
    https://leetcode.com/problems/valid-anagram
    Hash Table
    String
    Sorting
*/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("car", "rat"));
        System.out.println(solution.isAnagram("ggii", "eekk"));
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] strS = new char[26];
        char[] strT = new char[26];

        for (int i = 0; i < s.length(); i++) {
            strS[s.charAt(i) - 'a']++;
            strT[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(strT, strS);
    }
}
