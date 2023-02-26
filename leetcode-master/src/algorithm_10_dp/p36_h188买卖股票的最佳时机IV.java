package algorithm_10_dp;

public class p36_h188买卖股票的最佳时机IV {
    public static int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][k + 1][2];
        for(int i = 0; i < k + 1; i++) {
            dp[0][i][0] = - prices[0];
        }
        for(int i = 1; i < prices.length; i++) {
            for (int j = 1; j < k + 1; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] - prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] + prices[i]);
            }
        }
        return dp[prices.length - 1][k][1];
    }
    public static void main(String[] args) {
        int[] nums = {3,2,6,5,0,3};
        int res = maxProfit(2, nums);
        System.out.println(res);
    }
}
