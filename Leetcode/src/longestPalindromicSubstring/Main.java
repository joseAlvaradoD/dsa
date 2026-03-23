package longestPalindromicSubstring;

/*
    https://leetcode.com/problems/longest-palindromic-substring/
    Two Pointers, String, Dynamic Programming
 */

public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("bb"));
        System.out.println(solution.longestPalindrome("a"));

    }
}

class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        String longestPalindrome="";

        for(int i = 0; i < s.length(); i++){
            for (int j = i+1; j <= s.length(); j++){
                String subString = s.substring(i,j);

                int left=0, right=subString.length()-1;
                while(left < right){
                    if(subString.charAt(left) != subString.charAt(right)){
                        break;
                    }
                    left++;
                    right--;
                }

                if( (left>=right) && subString.length() > longestPalindrome.length()){
                    longestPalindrome = subString;
                }

            }
        }

        return longestPalindrome;
    }
}
