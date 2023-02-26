package algorithm_10_dp;

public class p24_m279完全平方数 {
    // 先背包后物品
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        int max = Integer.MAX_VALUE;
        for (int j = 0; j < dp.length; j++) {
            dp[j] = max;
        }
        dp[0] = 0;
        for (int j = 1; j <= n; j++) {
            for (int i = 1;  j - i* i >= 0; i++) {
                dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
            }
        }
        return dp[n];
    }
    public static int numSquares2(int n) {
        int[] dp = new int[n + 1];
        int max = Integer.MAX_VALUE;
        for (int j = 0; j < dp.length; j++) {
            dp[j] = max;
        }
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i ; j <= n; j++) {
                if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {

        int res = numSquares2(5);
        System.out.println(res);
    }
}
