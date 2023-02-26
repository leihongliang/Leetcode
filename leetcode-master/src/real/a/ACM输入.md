

2
2 2
1 3 3
3 1 4
```java
public class Main {
        //2 第一行输入一个正整数n，代表事件的数量
        //2 2 第二行输入两个正整数T和H，代表时间限制和精力限制。
        //1 3 3
        //3 1 4
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int T = sc.nextInt();int H = sc.nextInt();

        int[] t = new int[n+1];
        int[] h = new int[n+1];
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            h[i] = sc.nextInt();
            a[i] = sc.nextInt();
        }

        int[][] dp = new int[T+1][H+1];

        for (int i = 1 ; i <= n ; i++) {
            for (int j = T; j >= t[i]; j--) {
                for (int k = H ; k >= h[i] ; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-t[i]][k-h[i]] + a[i]);
                }
            }
        }
        System.out.println(dp[T][H]);
    }

}
```
