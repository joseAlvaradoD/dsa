package maximumProductSubarray;

public class Main {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minCurr = nums[0];
        int maxCurr = nums[0];

        for(int i = 1; i < nums.length; i++){

            int maxTmp = max(nums[i], maxCurr*nums[i], minCurr*nums[i]);

            minCurr = min(nums[i], maxCurr*nums[i], minCurr*nums[i]);

            maxCurr=maxTmp;

            maxProduct = Math.max(maxCurr, maxProduct);
        }


        return maxProduct;
    }
    private int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
    private int max(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }
}
