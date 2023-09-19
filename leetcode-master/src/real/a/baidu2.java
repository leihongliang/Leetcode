package real.a;

import java.util.Scanner;
/*
*
小红现在有两个数x和y，但是小红更喜欢y这个数，于是小红希望你帮她将x变成y。于是小红又找到了两个数a和b，她每次可以从以下两个操作中选择一项:

1. 选择一个偶数q(q \leq a)，令 x = x+q。
2. 选择一个奇数p(p \leq b)，令 x = x-p。

请你帮助小红找到x变成y的最小操作数。共有T组询问。
输入描述
输入共T+1行，第一行表示询问次数T
接下来T行，每行表示一次询问，输入四个正整数x,y,a,b
输出描述
T行，每行一个整数，表示最小操作数
示例1
输入
2
2 9 2 3
7 2 3 4
输出
5
3
说明
在询问1中，选择的操作为 -1 +2 +2 +2 +2
* */
public class baidu2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int T = scanner.nextInt();
        int T = 1;

        for (int i = 0; i < T; i++) {
//            int x = scanner.nextInt();
//            int y = scanner.nextInt();
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            int result = minimumOperations(x, y, a, b);
            int result = minimumOperations(7, 2, 3, 4);
            System.out.println(result);
        }

        scanner.close();
    }

    public static int minimumOperations(int x, int y, int a, int b) {
        int diff = Math.abs(x - y); // 计算x与y的差值
        int totalOps = 0;
        int minOps = Integer.MAX_VALUE;

        if (x < y) {
            // 将x增加到y，选择偶数操作
            if (diff % a == 0) {
                return diff / a;
            }
            for (int p = 1; p <= b; p += 2) {
                if ((diff - p) % a == 0) {
                    int ops = (diff + p) / a + 1;
                    return Math.min(minOps, ops);
                }
            }
        } else if (x > y) {
            if (diff % b == 0) {
                return diff / b;
            }
            for (int q = 1; q <= a; q += 2) {
                if ((diff + q) % b == 0) {
                    int ops = (diff + q)/b + 1;
                    return Math.min(minOps, ops);
                }
            }
        }
        return totalOps;
    }
}



