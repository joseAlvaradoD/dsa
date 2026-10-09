package minCostClimbingStairs;

public class Main {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length + 1];

        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        for (int i = 2; i <= cost.length; i++) {
            if (i < cost.length) {
                minCost[i] = cost[i] + Math.min(minCost[i - 2], minCost[i - 1]);
            } else {
                minCost[i] = Math.min(minCost[i - 2], minCost[i - 1]);
            }
        }
        return minCost[cost.length];
    }
}
