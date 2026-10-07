package bestTimeToBuyAndSellStock;

import utils.ListNode;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxProfit(new int[]{ 7,  1,  5,  3,  6,  4}));
                                                      // 0, -6,  4,  2,  5,  3
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(solution.maxProfit(new int[]{2,1,4}));
        System.out.println(solution.maxProfit(new int[]{2,1,2,1,0,1,2}));
    }
}
class Solution{
    public int maxProfit(int[] prices) {
        int minPrice=prices[0];
        int maxProfit = 0;
        int n= prices.length;
        int profit;
        for (int i = 1; i < n; i++){
            profit = prices[i] - minPrice;
            maxProfit = profit>maxProfit?profit:maxProfit;
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }

}
