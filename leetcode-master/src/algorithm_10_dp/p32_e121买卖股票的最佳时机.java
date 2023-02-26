package algorithm_10_dp;

public class p32_e121买卖股票的最佳时机 {
    public static int maxProfit0(int[] prices)  {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }

    public static int maxProfit1(int[] prices)  {
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
        }
        return dp[1];
    }
    /*
   贪心
     */
    public static int maxProfit(int[] prices)  {
        int res = 0;
        int low = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low , prices[i]);
            res = Math.max(prices[i] - low, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        int res = maxProfit(nums);
        System.out.println(res);
    }
}
