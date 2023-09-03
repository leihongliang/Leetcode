package algorithm_10_dp;

public class p14_m1049最后一块石头的重量2 {
    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) sum += stone;
        int bagWeight = sum / 2;
        int[] dp = new int[bagWeight  + 1];
        int k = 0;
        for (int i =0; i < stones.length; i++) {
            for (int j = bagWeight; j >= stones[i]; j--) {
                if (dp[j] < dp[j - stones[i]] + stones[i]){
                    dp[j] = dp[j - stones[i]] + stones[i];
                    k++;
                    System.out.println(j);
                }
            }
        }
        System.out.println(k/2);
        return sum - 2 * dp[bagWeight];
    }



    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int res = lastStoneWeightII(nums);
        System.out.println(res);
    }
}
