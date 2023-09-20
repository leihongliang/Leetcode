package real.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
用java写一下这道题
现在小明有一棵树。树上有很多节点，每个节点有一种颜色。
小明想要在树上找到两个点，这两个点具有相同的颜色，且距离最近。
你的任务是找到具有相同颜色的两个节点的最近距离。
如果树上不存在相同颜色的节点，输出-1。

输入描述
第一行是两个正整数n,m，表示网络中有n个节点，不超过m种颜色。节点被依次从1编号到n。颜色被依次从1编号到m。
接下来一行n个正整数，表示每个节点的颜色。
接下来n – 1行，每行两个正整数u, v，表示u和v之间有一条连边。保证能够构成一棵树。
数字间两两均有空格隔开。
对于100%的数据，1 <= n, m <= 500
输出描述
一行，一个正整数表示最近的距离。若不存在同色节点输出-1。

样例输入
5 5
1 2 3 4 5
1 2
2 3
3 4
4 5
样例输出
-1
提示
样例解释1
没有同色节点

输入样例2
5 5
1 2 3 4 1
1 2
2 3
3 4
4 5
输出样例2
4
样例解释2
有两个颜色1的节点，距离为4。

输入样例3
5 5
1 1 3 2 2
1 2
1 3
1 4
3 5
输出样例3
1
样例解释3
有两个颜色1的节点，距离为1。
有两个颜色2的节点，距离为3。
1是更小的答案。
* */
import java.util.*;

public class glodon1染色 {
    static int[] colors;
    static List<Integer>[] graph;
    static int minDistance;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        colors = new int[n];
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            colors[i] = scanner.nextInt();
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph[u - 1].add(v - 1);
            graph[v - 1].add(u - 1);
        }

        minDistance = Integer.MAX_VALUE;
        for (int i = 1; i <= m; i++) {
            findMinDistance(i);
        }

        if (minDistance == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDistance);
        }
    }

    static void findMinDistance(int color) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == color) {
                dfs(i, color, visited, 0);
            }
        }
    }

    static void dfs(int node, int targetColor, boolean[] visited, int distance) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                if (colors[neighbor] == targetColor) {
                    minDistance = Math.min(minDistance, distance + 1);
                }
                dfs(neighbor, targetColor, visited, distance + 1);
            }
        }
        visited[node] = false;
    }
}
