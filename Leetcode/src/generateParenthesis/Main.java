package generateParenthesis;

import java.util.ArrayList;
import java.util.List;

/*
    https://leetcode.com/problems/generate-parentheses
    String
    Dynamic Programming
    Backtracking
 */

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}

class Solution {
    private List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrack(StringBuilder sb, int open, int close, int n){
        if(n*2 == sb.length()){
            ans.add(sb.toString());
            return ;
        }

        if(open < n){
            backtrack(sb.append('('), open+1, close, n);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close < open){
            backtrack(sb.append(')'), open, close+1, n);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}