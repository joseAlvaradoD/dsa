package integerToRoman;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
    https://leetcode.com/problems/integer-to-roman
    Hash Table, Math, String
 */
public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println("Result: " + solution.intToRoman(3999));
        System.out.println("Result: " + solution.intToRoman(1));
    }
}

class Solution {
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        if(num == 0) return "";

        StringBuilder roman = new StringBuilder();

        for (int index=0; index<values.length; index++) {
            int times = num/values[index];
            num= num%values[index];
            roman.append(symbols[index].repeat(times));
        }


        return roman.toString();
    }
}
