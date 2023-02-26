package algorithm_10_dp;

public class p8_m343整数拆分 {
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int tmp = Math.max( j * (i - j), j * dp[i - j]);
                if (tmp > max) {
                    max = tmp;
                    dp[i] = max;
                }
            }
        }
        return dp[n];
    }



    public static void main(String[] args) {
        int res = integerBreak(5);
        System.out.println(res);
    }
}
