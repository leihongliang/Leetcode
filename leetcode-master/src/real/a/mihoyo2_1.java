package real.a;

/*
米小游有一个 n×m 的矩阵。如果一个矩阵存在一行或一列，其元素都是质数，那么这个矩阵就是质数矩阵。米小游每次可以选择矩阵的一个元素，将其加一。请问米小游最少需要多少次操作，才能将矩阵变成质数矩阵。
python提交推荐使用pypy语言提交
输入描述
第一行两个整数 n, m，表示矩阵的行数和列数。
接下来 n 行，每行 m 个整数，表示矩阵的元素 a_{ij}。
输出描述
输出一个整数，表示最少的操作次数。
示例1
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
2 2
1 2
3 4
输出
1
说明
将 a_{11} 加一即可，这样第一行第一列都是质数，都可以满足条件。
* */

import java.util.Scanner;

public class mihoyo2_1 {
    // 判断一个数是否是质数
    public static boolean isPrime(int x) {
        if (x < 2) return false;
        int sqrtX = (int) Math.sqrt(x);
        for (int i = 2; i <= sqrtX; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    // 找到一个数加一后最近的质数
    public static int nextPrime(int x, boolean[] prime) {
        if (prime[x]) return x;
        while (!prime[++x]) {}
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 矩阵的行数
        int m = sc.nextInt(); // 矩阵的列数
        int[][] a = new int[n][m]; // 矩阵的元素
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();

        // 构建质数表，用于快速判断质数
        boolean[] prime = new boolean[2 * Math.max(n, m)];
        prime[0] = prime[1] = false;
        for (int i = 2; i < prime.length; i++) {
            prime[i] = true;
        }
        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                for (int j = i * 2; j < prime.length; j += i) {
                    prime[j] = false;
                }
            }
        }

        // 计算每一行需要的操作次数
        int[][] diff = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int next = nextPrime(a[i][j], prime);
                diff[i][j] = next - a[i][j];
            }
        }

        int minRowSum = Integer.MAX_VALUE;
        int minColSum = Integer.MAX_VALUE;

        // 计算每行的和并找到最小值
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < m; j++) {
                rowSum += diff[i][j];
            }
            minRowSum = Math.min(minRowSum, rowSum);
        }

        // 计算每列的和并找到最小值
        for (int j = 0; j < m; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += diff[i][j];
            }
            minColSum = Math.min(minColSum, colSum);
        }

        System.out.println(Math.min(minRowSum, minColSum));
    }



}
