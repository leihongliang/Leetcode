package real.a;

/*
*
将一座山简化为包含非负整数m*n的网格，依照从左上角第一个元素到右下角最后一个元素的路径滚雪球，使得滚雪球路径上的数字总和为最小。
雪球只能向下或向右滚动，起点为左上角第一个节点代表山顶，终点为右下角最后一个元素代表山脚。m,n 均小于等于100

示例1
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
[[1,2,1],[1,3,4],[5,7,8]]
输出
16

* */
public class qunaer2雪山滚雪球dp {

        public static int minPathSum(int[][] paths) {
            int m = paths.length;
            int n = paths[0].length;

            // 创建一个二维数组来存储最小路径和
            int[][] dp = new int[m][n];

            // 初始化第一个元素
            dp[0][0] = paths[0][0];

            // 初始化第一行和第一列
            for (int i = 1; i < m; i++) {
                dp[i][0] = dp[i - 1][0] + paths[i][0];
            }
            for (int j = 1; j < n; j++) {
                dp[0][j] = dp[0][j - 1] + paths[0][j];
            }

            // 填充其余部分
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + paths[i][j];
                }
            }

            return dp[m - 1][n - 1];
        }

        public static void main(String[] args) {
            int[][] grid = {
                    {1, 2, 1},
                    {1, 3, 4},
                    {5, 7, 8}
            };
            int result = minPathSum(grid);
            System.out.println(result);
        }



}
