package real.a;

import java.util.*;
/*
有n 个点，第i个点的坐标为 xi，第i个点的颜色为ci。
如果ci = 0，则第i个点为红点。
如果ci = 1，则第i个点为蓝点
每次你可以做以下两种操作之一:
1.选择一个红点，设这个红点的坐标为 x，把这个点移动到 x - 1 或x + 1。
2.选择一个蓝点，将它变为红点
你可以最多做 k 次操作2。求最少要进行多少次操作1可以便得任意两个红点之间不存在蓝点。
即设两个红点分别在坐标x,y(x <= y)，则不存在任何一个蓝点的坐标在区间 [x,y]内。
输入描述
第一行两个整数n,k
第一行 n 个整数x1,x2,...,xn
第三行 n 个整数c1,c2,...,cn
输出描述
输出一行一个整数表示答案。
输入
5 0
2 7 9 14 20
0 1 0 0 1
输出
6
* */

public class tx25红点蓝点 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] x = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }

        int[] redCount = new int[n]; // 记录每个位置之前的红点数
        int[] redDistance = new int[n]; // 记录每个位置之前的最短操作次数

        // 初始化红点计数和距离数组
        if (c[0] == 0) {
            redCount[0] = 1;
        }
        redDistance[0] = 0;

        for (int i = 1; i < n; i++) {
            if (c[i] == 0) {
                redCount[i] = redCount[i - 1] + 1;
            } else {
                redCount[i] = redCount[i - 1];
            }
            int distance = x[i] - x[i - 1] - 1;
            redDistance[i] = redDistance[i - 1] + distance;
        }

        // 动态规划求解最小操作次数
        int[][] dp = new int[n][k + 1];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                // 操作2：将当前蓝点变为红点
                if (c[i] == 1 && j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }

                // 操作1：将当前红点移动到前面的某个红点位置
                for (int m = 0; m < i; m++) {
                    int redPoints = redCount[i] - redCount[m];
                    int distance = redDistance[i] - redDistance[m];
                    int cost = (redPoints == 0) ? 0 : (distance - redPoints + 1);
                    if (j >= cost) {
                        dp[i][j] = Math.min(dp[i][j], dp[m][j - cost] + distance);
                    }
                }
            }
        }

        // 找到最小操作次数
        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j <= k; j++) {
            minCost = Math.min(minCost, dp[n - 1][j]);
        }

        System.out.println(minCost);
    }
}










