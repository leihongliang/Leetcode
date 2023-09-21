package real.a;

import java.util.Arrays;
import java.util.Scanner;
/*
现在有一批长度不同的木材woods，现在需要将木材进行拼接，正好达到总长度length,在不考虑切割木材，并且每种长度的木材不限量供应情况下，返回满足要求的最少木材数量，如果无法通过组合达到规定长度，则返回-1。
[1,2,3,5]
9
 */
public class sxf3木材背包 {
    public static int minCoins(int[] num, int a) {
        int n = num.length;
        int[] dp = new int[a + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= a; i++) {
            for (int j = 0; j < n; j++) {
                if (num[j] <= i && dp[i - num[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - num[j]]);
                }
            }
        }
        if (dp[a] == Integer.MAX_VALUE) {
            return -1;
        }else {
            return dp[a];
        }


    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String[] strArr = str.substring(1, str.length() - 1).split(",");
        int[] woods = new int[strArr.length + 1];
        for (int i = 0; i < strArr.length; i++) {
            woods[i] = Integer.parseInt(strArr[i].trim());
        }
        int length = input.nextInt();
        System.out.println(minCoins(woods, length));
    }

}
