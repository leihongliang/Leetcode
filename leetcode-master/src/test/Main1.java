package test;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();
        System.out.println(solve(x, y));
    }



    public static int solve(int x, int y) {
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 1; i <= x; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= x; i++) {
            for (int j = 2; j <= y; j++) {
                if (i >= j) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - j][j];
                }
            }
        }
        return dp[x][y];
    }
    public static int solve2(int x, int y) {
        if (y == 1) {
            return 1; // 每组至少有一个元素，只有一种方法
        }
        if (x < y) {
            return 0; // 总数小于组数，无法分组
        }
        return solve2(x - 1, y - 1) + solve2(x - y, y);
    }

}







