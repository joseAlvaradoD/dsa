package validAnagram;

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
        char[] strS = new char[28];
        char[] strT = new char[28];

        for (int i = 0; i < s.length(); i++) {
            strS[s.charAt(i) - 'a']++;
            strT[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < strS.length; i++) {
            if(strT[i] != strS[i]) return false;
        }

        return true;
    }
}
