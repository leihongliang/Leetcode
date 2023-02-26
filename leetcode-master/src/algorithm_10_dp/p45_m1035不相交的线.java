package algorithm_10_dp;

public class p45_m1035不相交的线 {
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        for (int i = 1; i < nums1.length + 1; i++ ) {
            for (int j = 1; j < nums2.length + 1; j++ ) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j - 1],  dp[i][j]);
                }
            }
        }
        return dp[nums1.length][nums2.length];

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};
        int res = maxUncrossedLines(nums1, nums2);
        System.out.println(res);
    }
}
