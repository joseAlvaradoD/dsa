package zigzagConversion;

/*
    https://leetcode.com/problems/zigzag-conversion
    String
*/

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.",3));
    }

}
class Solution{
    public String convert(String s, int numRows) {
        if(numRows <= 1 || s.length() <= numRows) return s;

        StringBuilder[] zigzag = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            zigzag[i] = new StringBuilder();
        }
        int currRow=0;
        boolean goingDown = false;
        for(char ch : s.toCharArray()){
            zigzag[currRow].append(ch);

            if(currRow == 0 || currRow == numRows-1){
                goingDown = !goingDown;
            }

            currRow+=goingDown?1:-1;
        }

        StringBuilder sb = new StringBuilder();

        for (StringBuilder row: zigzag) {
                sb.append(row);
        }

        return sb.toString();
    }
}
