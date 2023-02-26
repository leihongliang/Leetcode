package real.a;

import java.util.Scanner;

public class adp小红书_小红的分享日常 {
    public static void main(String[] args) {
        // 2 第一行输入一个正整数n，代表事件的数量
        // 2 2 第二行输入两个正整数T和H，代表时间限制和精力限制。
        // 1 3 3 接下来的n行，每行输入三个正整数ti,hi，ai，代表分享第i个事件需要花费ti的时间、hi的精力，收获ai的快乐值。
        // 3 1 4
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //物品
        int T = sc.nextInt(); //bagWeight1
        int H = sc.nextInt(); //bagWeight2

        int[] t = new int[n]; //weight1
        int[] h = new int[n]; //weight2
        int[] a = new int[n]; //value
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            h[i] = sc.nextInt();
            a[i] = sc.nextInt();
        }

        int[][] dp = new int[T + 1][H + 1];
        /*
        [00000]
        [00033]
        [00033]
        [00044]
        [04447]*/

        for (int i = 0; i < n; i++) {
            for (int j = T; j >= t[i]; j--) {
                for (int k = H; k >= h[i]; k--) {
                    dp[j][k] = Math.max(dp[j][k], a[i] + dp[j - t[i]][k - h[i]] );
                    //dp[j] = Math.max(dp[j], value[i] + dp[j - weight[i]]);
                }
            }
        }
        System.out.println(dp[T][H]);
    }

}
