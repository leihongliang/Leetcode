package algorithm_10_dp;

import java.util.HashMap;

public class p2_e509斐波那契数 {
    public static int fib(int n) {
        HashMap map = new HashMap();
        map.put(1,1);
        int res = 0;
        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 0; i < n; i++) {
            dp[i + 2] = dp[i] + dp[i + 1];
        }
        res = dp[n + 2];
        return res;
    }
    public static int fib2(int n) {
        int res = 0;
        int dp0 = 0;
        int dp1 = 1;
        for (int i = 1; i < n; i++) {
            res = dp0 + dp1;
            dp0 = res;
            dp1 = dp0;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = fib2(2);
        System.out.println(res);

    }
}
