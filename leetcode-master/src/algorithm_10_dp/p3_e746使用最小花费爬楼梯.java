package algorithm_10_dp;

public class p3_e746使用最小花费爬楼梯 {
    public static int minCostClimbingStairs(int[] cost) {
        int res =  0;
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public static void main(String[] args) {
        int[] cost = {10,15,20};
//        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int res = minCostClimbingStairs(cost);
        System.out.println(res);

    }
}
