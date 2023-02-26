package algorithm_10_dp;

public class p19_m518零钱兑换II {
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }



    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int res = change(5, coins);
        System.out.println(res);
    }
}
