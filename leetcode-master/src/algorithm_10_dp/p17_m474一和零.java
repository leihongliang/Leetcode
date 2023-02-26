package algorithm_10_dp;

public class p17_m474一和零 {
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeroCount = 0 ;
            int oneCount = 0 ;
            for (int i = 0; i < str.length(); i++) {
                if ( str.charAt(i) == '0') zeroCount++;
                if ( str.charAt(i) == '1') oneCount++;
            }

            for(int i = m; i >= zeroCount; i--) {
                for(int j = n; j >= oneCount; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroCount][j - oneCount] + 1);
                }
            }
        }
        return dp[m][n];

    }



    public static void main(String[] args) {
        String[] nums = {"10", "0001", "111001", "1", "0"};
        int res = findMaxForm(nums, 5, 3);
        System.out.println(res);
    }
}
