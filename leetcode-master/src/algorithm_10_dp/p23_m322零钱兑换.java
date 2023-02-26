package algorithm_10_dp;

public class p23_m322零钱兑换 {
    public static int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        for (int j = 0; j < dp.length; j++) {
            dp[j] = max;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return  dp[amount] == max ? -1 : dp[amount];
    }
    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int j = 0; j < dp.length; j++) {
            dp[j] = j ;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != j) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == amount ? -1 : dp[amount];
    }



    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
        int[] coins = {2};
        int res = coinChange2(coins,3);
        System.out.println(res);
    }
}
