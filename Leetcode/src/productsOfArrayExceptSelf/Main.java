package productsOfArrayExceptSelf;

/*
    https://leetcode.com/problems/product-of-array-except-self
    Array
    Prefix Sum
 */

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        utils.Arrays.print(solution.productExceptSelf(new int[]{1,2,3,4}));
        utils.Arrays.print(solution.productExceptSelf(new int[]{-1,1,0,-3,3}));
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        int i = 1, j = n-2;
        prefix[0] = nums[0];
        suffix[n-1] = nums[n-1];
        while(i<nums.length && j>=0){
            prefix[i] = nums[i] * prefix[i-1];
            suffix[j] = nums[j] * suffix[j+1];

            i++;
            j--;
        }

        int [] result = new int[n];

        for(i = 0; i < n; i++){
            if(i==0){
                result[i] = suffix[i+1];
            }else if(i == n-1){
                result[i] = prefix[i-1];
            }else{
                result[i] = prefix[i-1] * suffix[i+1];
            }

        }

        return result;
    }
}
