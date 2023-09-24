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

public class mihoyo2 {

    // 判断一个数是否是质数
    public static boolean isPrime(int x) {
        if (x < 2) return false;
        if (x == 2 || x == 3) return true; // 2和3是特殊的质数
        if (x % 6 != 1 && x % 6 != 5) return false; // 如果不满足6n+1或6n-5的形式，则一定不是质数
        for (int i = 5; i * i <= x; i += 6) { // 只遍历6n+1或6n-1的形式，并且只遍历到立方根
            if (x % i == 0 || x % (i + 2) == 0) return false;
        }
        return true;
    }

    // 找到一个数加一后最近的质数
    public static int nextPrime(int x) {
        if (isPrime(x)) return x;
        while (!isPrime(x + 1)) {
            x++;
        }
        return x + 1;
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

        // 计算每一行和每一列需要的操作次数
        int[][] prime = new int[n][m]; // 每一行需要的操作次数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int diff = nextPrime(a[i][j]);
                prime[i][j] = diff - a[i][j];
            }
        }

        int minRowSum = Integer.MAX_VALUE;
        int minColSum = Integer.MAX_VALUE;

        // 计算每行的和并找到最小值
        for (int i = 0; i < prime.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < prime[i].length; j++) {
                rowSum += prime[i][j];
            }
            minRowSum = Math.min(minRowSum, rowSum);
        }
        for (int j = 0; j < prime[0].length; j++) {
            int colSum = 0;
            for (int i = 0; i < prime.length; i++) {
                colSum += prime[i][j];
            }
            minColSum = Math.min(minColSum, colSum);
        }
        System.out.println(Math.min(minColSum, minRowSum));
    }
}
