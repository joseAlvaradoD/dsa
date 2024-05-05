package jjad.dsa.string.search;


/*
String Search:
Given a string s, find the length of the longest substring without repeating characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Constraints:
 0 <= s.length <= 5 * 104
 s consists of English letters, digits, symbols and spaces.
*/



import java.util.*;

public class Main {

    public static void main(String[] args){
        String [] strs = {"aaab","abcabcabb","abcabca bb","bbbbb","pwwkew","au","auu","aui","tmmzuxt"};

        for(String str : strs){
            System.out.println(longestSubstring(str));
        }
    }

    public static String longestSubstring(String str){

        if(str.length() == 1){
            return str;
        }
        //this variable can be interchange for a char array
        StringBuilder sbAns = new StringBuilder();
        byte set[] = new byte[128];
        final char[] chars = str.toCharArray();
        String ans = "";

        for(int right = 0; right < chars.length; right++){
            if(set[chars[right]] == 0){
                set[chars[right]] = 1;
                sbAns.append(chars[right]);
            }else{
                ans = ans.length()<sbAns.toString().length()? sbAns.toString(): ans;

                sbAns = new StringBuilder(sbAns.toString().substring(sbAns.toString().indexOf(chars[right]) + 1));

                sbAns.append(chars[right]);
            }
        }

        ans = ans.length()<sbAns.toString().length()? sbAns.toString(): ans;

        return ans;
    }

}

