package algorithm_10_dp;

public class p34_m122买卖股票的最佳时机II {
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];//持有
        dp[0][1] = 0;//不持有
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]-prices[i]);//（不操作，今天买入（昨天一定要为不持有状态））
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]+prices[i]);//（不操作，今天卖出（昨天一定要为持有状态））
        }
        return dp[prices.length - 1][1];

    }
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        int res = maxProfit(nums);
        System.out.println(res);
    }
}
