package algorithm_10_dp;

public class p50_d72编辑距离 {
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word2.length() + 1][word1.length() + 1];
        for (int j = 0; j < word1.length() + 1; j++) dp[0][j] = j;
        for (int i = 0; i < word2.length() + 1; i++) dp[i][0] = i;
        for (int i = 1; i < word2.length() + 1; i++) {
            for (int j = 1; j < word1.length() + 1; j++) {
                if (word2.charAt(i - 1) ==  word1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j -1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[word2.length()][word1.length()];
    }


    public static void main(String[] args) {
        String s = "horse";
        String t = "ros";
        int res = minDistance(s, t);
        System.out.println(res);
    }
}
