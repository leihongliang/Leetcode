package real.a;

import java.util.*;
/*
班级组织传球活动，男女同学随机排成m行n列队伍，第一列中的任意一个男同学都可以作为传球的起点，要求最终将球传到最后一列的任意一个男同学手里，求所有能够完成任务的传球路线中的最优路线（传球次数最少的路线）的传球次数。
传球规则：

男同学只能将球传给男同学，不能传给女同学。
球只能传给身边前后左右相邻的同学。
如果游戏不能完成，返回-1。
说明：
传球次数最少的路线为最优路线。
最优路线可能不唯一，不同最优路线都为最少传球次数。
输入
班级同学随机排成的m行n列队伍，1代表男同学，0代表女同学。
输入第一行包含两个用空格分开的整数m [1, 30]和n [1, 30]，表示m行n列的队伍；接下来是m行每行包含n个用空格分开的整数1或0。

输出
最优路线的传球次数（最少传球次数）。
样例1
复制输入：
4 4
1 1 1 0
1 1 1 0
0 0 1 0
0 1 1 1
复制输出：
5

* */

public class huawei2 {
    // 用于寻找一个班级排列矩阵中从左侧到右侧的最佳通行路线。
    static int bestPassRoute(int[][] classArrangement, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();  // 创建一个队列用于广度优先搜索
        Map<Integer, Integer> map = new HashMap<>(); // 创建一个映射用于记录每个位置的最短距离
        // 初始化起始点，从第一列中值为1的位置出发，将它们添加到队列和映射中
        for (int i = 0; i < m; i++) {
            if (classArrangement[i][0] == 1) {
                queue.add(new int[]{i, 0});// 初始点[0,0][1,0]
                map.put(i * 100, 0); // 记录距离为0 <0,0> <100,0>
            }
        }

        int[] dx = {-1, 0, 1, 0}; //上右下左
        int[] dy = {0, 1, 0, -1}; //上右下左

        // 进入广度优先搜索循环，直到队列为空
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0]; //行x
            int col = curr[1]; //行y

            if (col == n - 1) {
                return map.get(row * 100 + col);
            }
            //上右下左
            for (int i = 0; i < 4; i++) {
                int newRow = row + dx[i];
                int newCol = col + dy[i];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && classArrangement[newRow][newCol] == 1) {
                    if (!map.containsKey(newRow * 100 + newCol)) {
                        queue.add(new int[]{newRow, newCol});
                        map.put(newRow * 100  + newCol, map.get(row * 100 + col) + 1);
                    }
                }
            }
        }

        return -1;
    }

    // 提交版本
    // 枚举第一列的所有的点，做一次BFS，判断走到最后一列的最短距离即可
    static int pass(int[][] mat, int m, int n) {
        Queue<int[]> queue = new LinkedList<>(); // 创建一个队列用于广度优先搜索
        Map<Integer, Integer> map = new HashMap<>(); // 创建一个映射用于记录每个位置的最短距离，到过的就不用再次访问了
        for (int i = 0; i < m; i++) {
            if (mat[i][0] == 1) {
                queue.add(new int[]{i, 0});
                map.put(i * 100, 0);
            }
        }
        int[] dx = {-1, 0, 1, 0}; //上右下左
        int[] dy = {0, 1, 0, -1}; //上右下左
        // BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0]; //行x
            int col = curr[1]; //行y
            if (col + 1 == n) {
                return map.get(row * 100 + col);
            }
            for (int i = 0; i < 4; i++) {
                int row2 = row + dx[i];
                int col2 = col + dy[i];
                // 判断是否越界，以及是否来过
                if (row2 >= 0 && row2 < m && col2 >= 0 && col2 < n) {
                    if (mat[row2][col2] == 1 && !map.containsKey(row2 * 100 + col2)) {
                        queue.add(new int[]{row2, col2});
                        map.put(row2 * 100 + col2, map.get(row * 100 + col) + 1);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int m = scanner.nextInt();
//        int n = scanner.nextInt();
        int m = 4;
        int n = 4;
//        int[][] matrix = new int[m][n];

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = scanner.nextInt();
//            }
//        }
        int[][] matrix ={{1,1,1,0},
                        {1,1,1,0},
                        {0,0,1,0},
                        {0,1,1,1}};

        System.out.println(pass(matrix, m, n));
    }
}
