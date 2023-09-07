package real.a;

import java.util.Scanner;

public class trip2三角形 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 矩阵的行数
        int m = sc.nextInt(); // 矩阵的列数
        sc.nextLine(); // 读取换行符
        char[][] matrix = new char[n][m]; // 存储矩阵
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine(); // 读取一行字符串
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.charAt(j); // 将字符串转为字符数组
            }
        }
        sc.close(); // 关闭输入流
        int count = 0; // 记录满足条件的三角形个数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = matrix[i][j]; // 当前字符
                if (c == 'y') { // 如果是y，就向右和向下寻找o和u
                    for (int k = j + 1; k < m; k++) { // 向右寻找o
                        if (matrix[i][k] == 'o') {
                            int len = k - j; // 计算边长
                            if (i + len < n && matrix[i + len][k] == 'u') { // 如果向下也有u，就找到一个三角形
                                count++;
                            }
                        }
                    }
                    for (int k = i + 1; k < n; k++) { // 向下寻找o
                        if (matrix[k][j] == 'o') {
                            int len = k - i; // 计算边长
                            if (j + len < m && matrix[k][j + len] == 'u') { // 如果向右也有u，就找到一个三角形
                                count++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count); // 输出结果
    }
}
