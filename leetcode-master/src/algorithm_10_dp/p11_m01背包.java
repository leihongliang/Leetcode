package algorithm_10_dp;

public class p11_m01背包 {
    /***
     * 01 背包 二维数组背包
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagsize){
        // dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，其的最大价值
        // 不放物品i dp[i - 1][j]
        // 放物品i dp[i][j] 减去物品i的重量，其能放i -1 的最大价值
        int wlen  = value.length;
        int[][] dp = new int[wlen + 1][bagsize + 1];
        for (int i = 0; i < wlen + 1; i++) dp[i][0] = 0;
//        for (int j = 0; j < bagsize + 1; j++) dp[0][j] = 0;
        for (int i = 1; i < wlen + 1; i++) {
            for (int j = 1; j < bagsize + 1; j++) {
                // 判断第i个物品的重量
                if (weight[i - 1] <= j) {
                    // 物品i的价值 + 不放物品i的最大价值
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weight[i - 1]]);
                }else {
                    // 不放物品i
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i <= wlen; i++){
            for (int j = 0; j <= bagsize; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    /**
     * 01背包 滚动数组
     */
    public static void testWeightBagProblem2(int[] weight, int[] value, int bagWeight){
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < value.length; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        for (int j = 0; j <= bagWeight; j++){
            System.out.print(dp[j] + " ");
        }
    }

    public static void testCompletePack(int[] weight, int[] value, int bagWeight){
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < value.length; i++) {
            for (int j = weight[i]; j <= bagWeight; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        for (int j = 0; j <= bagWeight; j++){
            System.out.print(dp[j] + " ");
        }
    }


    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagsize = 4;
        //0 0  0  0  0
        //0 15 15 15 15
        //0 15 15 20 35
        //0 15 15 20 35
        testCompletePack(weight, value, bagsize);
    }

}
