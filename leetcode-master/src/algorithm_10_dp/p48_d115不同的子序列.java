package algorithm_10_dp;

public class p48_d115不同的子序列 {
    public static int numDistinct0(String s, String t)  {
        int[][] dp = new int[t.length() + 1][s.length() +1];
        for (int j = 1; j < s.length() + 1; j++) {
            if (t.charAt(0) == s.charAt(j - 1) && dp[1][j - 1] != 0){
                dp[1][j] = dp[1][j - 1] + 1;
            }else if(t.charAt(0) == s.charAt(j - 1) && dp[1][j - 1] == 0){
                dp[1][j] =  1;
            }else {
                dp[1][j] = dp[1][j - 1];
            }
        }
        for (int i = 2; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
    public static int numDistinct(String s, String t)  {
        int[][] dp = new int[t.length() + 1][s.length() +1];
        for (int j = 0; j < s.length() + 1; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        int res = numDistinct(s, t);
        System.out.println(res);
    }
}
