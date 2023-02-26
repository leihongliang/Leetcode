package test;

public class test {
    public static int maxHappiness(int n, int[][] events, int T, int H) {
        int[][] dp = new int[H + 1][T + 1];

        for (int i = 1; i <= n; i++) {
            int ti = events[i - 1][0];
            int hi = events[i - 1][1];
            int ai = events[i - 1][2];

            for (int j = H; j >= hi; j--) {
                for (int k = T; k >= ti; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - hi][k - ti] + ai);
                }
            }
        }

        return dp[H][T];
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] events = {{1, 3, 3}, {3, 1, 4}};
        int T = 1;
        int H = 3;

        int result = maxHappiness(n, events, T, H);
        System.out.println(result);  // 输出最大快乐值
    }
}

