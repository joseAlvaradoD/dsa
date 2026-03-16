package stringToInteger;
/*
    https://leetcode.com/problems/string-to-integer-atoi
    String
 */
public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("   -042"));
        System.out.println(solution.myAtoi("1337c0d3"));
        System.out.println(solution.myAtoi("0-1"));
        System.out.println(solution.myAtoi("-+12"));
    }
}

class Solution {
    public int myAtoi(String s) {
        StringBuilder result = new StringBuilder();
        boolean numberStarted = false;
        boolean signedFounded = false;

        for(char ch : s.toCharArray()){
            if(!numberStarted && ch == ' '){
                continue;
            }
            if(Character.isDigit(ch) || isNegativeSign(ch) ){
                if(!numberStarted){
                    signedFounded=isNegativeSign(ch);
                    numberStarted = true;
                    result.append(ch);
                }else if(isNegativeSign(ch)){
                    if(signedFounded) return 0;
                    break;
                }else{
                    result.append(ch);
                }
            }else{
                break;
            }
        }
        Long longNumber = Long.valueOf(result.toString().isBlank() || result.toString().equals("-")?"0":result.toString());
        if(longNumber >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(longNumber <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return longNumber.intValue();
    }
    private boolean isNegativeSign(char ch){
        return ch=='-';
    }
}
