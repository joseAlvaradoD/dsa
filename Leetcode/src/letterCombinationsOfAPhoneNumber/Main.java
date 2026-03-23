package letterCombinationsOfAPhoneNumber;

import java.util.*;

/*
    https://leetcode.com/problems/letter-combinations-of-a-phone-number
    Hash Table String
    Backtracking https://www.geeksforgeeks.org/dsa/backtracking-algorithms/
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.letterCombinations("2"));
        System.out.println(solution.letterCombinations("23"));
    }
}

class Solution {
    private static final Map<Character, List<Character>> keyNumberLetters;
    static {
        keyNumberLetters = new HashMap<>();
        keyNumberLetters.put('2',Arrays.asList('a','b','c'));
        keyNumberLetters.put('3',Arrays.asList('d','e','f'));
        keyNumberLetters.put('4',Arrays.asList('g','h','i'));
        keyNumberLetters.put('5',Arrays.asList('j','k','l'));
        keyNumberLetters.put('6',Arrays.asList('m','n','o'));
        keyNumberLetters.put('7',Arrays.asList('p','q','r','s'));
        keyNumberLetters.put('8',Arrays.asList('t','u','v'));
        keyNumberLetters.put('9',Arrays.asList('w','x','y','z'));
    }
    private List<String> ans = new ArrayList<>();
    private int n;
    public List<String> letterCombinations(String digits) {
        n = digits.length();
        int i = 0;

        backtracking(new StringBuilder(), i, digits);
        return ans;
    }
    
    private void backtracking(StringBuilder sb, int i, String digits){
        if(sb.length() == n){
            ans.add(sb.toString());
            return;
        }

        for (Character ch: keyNumberLetters.get(digits.charAt(i))){
            sb.append(ch);
            backtracking(sb, i+1, digits);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
