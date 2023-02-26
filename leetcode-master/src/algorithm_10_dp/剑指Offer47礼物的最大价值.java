package algorithm_10_dp;

public class 剑指Offer47礼物的最大价值 {
    public static int maxValue(int[][] grid) {
        int m = grid.length + 1;
        int n = grid[0].length + 1;
        int[][] dp = new int[m][n];
        // for (int i = 0; i < m; i++) dp[i][0] = grid[i][0];
        // for (int j = 0; j < n; j++) dp[0][j] = grid[0][j];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int tmp = grid[i - 1][j - 1];
                dp[i][j] = Math.max(dp[i - 1][j] + grid[i - 1][j - 1], dp[i][j - 1] + grid[i - 1][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
            };

        int n = maxValue(obstacleGrid);
        System.out.println(n);
    }
}
