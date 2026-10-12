package missingNumber;

public class Main {
    class Solution {
        public int missingNumber(int[] nums) {
            int ans = 0;
            for(int i = 0; i < nums.length; i++){
                ans ^= i ^ nums[i];
            }
            ans ^= nums.length;

            return ans;
        }

    }
}
