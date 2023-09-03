package real.a;

import java.util.*;


public class bytedance4 {
        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            int n = sc.nextInt();
            int n =3;
//            int[] a = new int[n];
            int[] stones = {1,2,3};
//            for (int i = 0; i < n; i++) {
//                a[i] = sc.nextInt();
//            }
//            sc.close();
//            Arrays.sort(a);
//            int h = a[0];
//            int k = 0;
//            StringBuilder sb = new StringBuilder();
//            for (int i = 1; i < n; i++) {
//                if (a[i] > 0) {
//                    k++;
//                    sb.append(1).append(" ").append(i + 1).append("\n");
//                    h = Math.abs(h - a[i]);
//                }
//            }
            int h = stones[0];
            int k = 0;
            int sum = 0;
            for (int stone : stones) sum += stone;
            int bagWeight = sum / 2;
            int[] dp = new int[bagWeight  + 1];
            StringBuilder sb = new StringBuilder();
            for (int i =0; i < stones.length; i++) {
                for (int j = bagWeight; j >= stones[i]; j--) {
                    if (dp[j] < dp[j - stones[i]] + stones[i]){
                        dp[j] = dp[j - stones[i]] + stones[i];
//                        System.out.println(j);
                        k++;
                    }
                    sb.append(1).append(" ").append(j).append("\n");
                }
            }
            h = sum - 2 * dp[bagWeight];
            System.out.println(h);
            System.out.println(k/2);
            System.out.print(sb.toString());
        }

}



