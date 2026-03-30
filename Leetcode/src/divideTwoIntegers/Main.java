package divideTwoIntegers;
/*
    https://leetcode.com/problems/divide-two-integers
    Math
    Bit Manipulation
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(10,3));// 1010  =  10;  0001 = 1
        System.out.println(solution.divide(10,2));// 1010  =  10;  0010 = 2
    }
}
class Solution {
    public int divide(int dividend, int divisor) {
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);

        long quotient = 0;

        // Perform the division using bit manipulation
        // Iterate from the largest possible power of two down to 0
        for (int i = 31; i >= 0; i--) {
            // Check if ldivisor shifted left by i (ldivisor * 2^i) is less than or equal to the current ldividend

            if ((ldivisor << i) <= ldividend) {
                System.out.println(i);
                System.out.println(ldividend + " | " + ldivisor + " = " + quotient) ;
                // If it is, add 2^i to the quotient
                quotient += (1L << i);
                // Subtract the shifted divisor from the dividend
                ldividend -= (ldivisor << i);
                System.out.println(ldividend + " | " + ldivisor + " = " + quotient) ;
            }
        }

        return (int) quotient;
    }
}
