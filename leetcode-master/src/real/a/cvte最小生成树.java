package real.a;

import java.util.Arrays;
import java.util.Scanner;

//https://www.luogu.com.cn/problem/P1546
public class cvte最小生成树 {
     static final int INF = Integer.MAX_VALUE; // 常量INF


     static int prim(int[][] g, int[] dist, int n, boolean[] vis) {

        // 初始化
        for (int i = 0; i < 4; i++) {
            dist[i] = INF; // 初始距离设为无穷大
            vis[i] = false; // 初始都未访问过
        }
        dist[0] = 0; // 从第一个产业园开始

        int res = 0; // 存储最小行驶距离

        // 循环n次，每次加入一个产业园到路线中
        for (int i = 0; i < n; i++) {
            // 找到距离最近的未访问过的产业园
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && (u == -1 || dist[j] < dist[u])){
                    u = j;
                }
            }
            if (dist[u] == INF) return -1; // 如果找不到合适的产业园，返回-1
            vis[u] = true;// 加入到路线中，并更新总距离


            res += dist[u];
            for (int j = 0; j < n; j++) {
                if (!vis[j]) {
                    dist[j] = Math.min(dist[j], g[u][j]); // 更新其他产业园到路线的最短距离
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        // 输入产业园个数
//        int n = scanner.nextInt();
        int n = 4;

        // 创建一个二维数组来存储产业园之间的距离
//        int[][] g = new int[n][n];

        // 输入距离信息
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                g[i][j] = scanner.nextInt();
//            }
//        }
        int[][]  g = {{0, 2, 6, 5},
                {2, 0, 4, 4},
                {6, 4, 0, 2},
                {5, 4, 2, 0}};
//        int[][]  g = {
//                     {0,  4, 9, 21},
//                     {4,  0, 8, 17},
//                     {9,  8, 0, 16},
//                     {21,17, 16, 0}};
        // 读取输入
        int[] dist = new int[n];
        boolean[] vis = new boolean[n]; // 标记每个产业园是否已经加入到路线中
        System.out.println(prim(g, dist, n, vis)); // 输出结果
    }
}
