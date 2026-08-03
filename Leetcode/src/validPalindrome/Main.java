package validPalindrome;

/*
    https://leetcode.com/problems/valid-palindrome
    two pointer
    String
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isPalindrome("Was it a car or a cat I saw?"));//true
        System.out.println(solution.isPalindrome("tab a cat"));//false
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));//true
        System.out.println(solution.isPalindrome("race a car"));//false
        System.out.println(solution.isPalindrome(" "));//true
    }
}
class Solution{
    public boolean isPalindrome(String s) {
        if(s == null) return false;

        s = s.toLowerCase().replaceAll("\\s","").replaceAll("[^a-z0-9]","");

        int left = 0;
        int right = s.length()-1;

        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
