package maximumSubarray;

public class Main {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i: nums){
            sum+=i;

            maxSum = Math.max(maxSum, sum);

            if(sum<0) sum = 0;
        }
        return maxSum;
    }

    public int maxSubArray_2(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i: nums){
            if(sum<i){
                sum = Math.max(i, sum+i);
            }else{
                sum+=i;
            }

            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
