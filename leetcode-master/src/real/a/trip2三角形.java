package real.a;

import java.util.Scanner;
/*
游游拿到了一个字符矩阵，她想知道有多少个三角形满足以下条件：
1. 三角形的三个顶点分别是 y、o、u 字符。
2. 三角形为直角三角形，且两个直角边一个为水平、另一个为垂直。
输入描述
第一行输入两个正整数n,m，用空格隔开，代表矩阵的行数和列数。
接下来的n行，每行输入一个长度为m的字符串，代表游游拿到的矩阵。
1\leq n,m \leq 1000
输出描述
输出一个整数，代表满足条件的三角形个数。
示例1
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
复制
2 3
you
our
输出
复制
3
*/
public class trip2三角形 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();

        String[] s = new String[m];
        for (int i = 0; i < m; i++) {
            s[i] = in.nextLine();

        }

        long ans = 0;
        int[][] row = new int[m][3]; // 初始化每行的统计信息
        int[][] col = new int[n][3]; // 初始化每列的统计信息

        // 统计每行和每列中 'y', 'o', 'u' 的数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = s[i].charAt(j);
                if (c == 'y') {
                    row[i][0]++;
                    col[j][0]++;
                } else if (c == 'o') {
                    row[i][1]++;
                    col[j][1]++;
                } else if (c == 'u') {
                    row[i][2]++;
                    col[j][2]++;
                }
            }
        }

        // 计算答案
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = s[i].charAt(j);
                if (c == 'y') {
                    ans += row[i][1] * col[j][2];
                    ans += row[i][2] * col[j][1];
                } else if (c == 'o') {
                    ans += row[i][0] * col[j][2];
                    ans += row[i][2] * col[j][0];
                } else if (c == 'u') {
                    ans += row[i][1] * col[j][0];
                    ans += row[i][0] * col[j][1];
                }
            }
        }

        System.out.println(ans);
    }
}
