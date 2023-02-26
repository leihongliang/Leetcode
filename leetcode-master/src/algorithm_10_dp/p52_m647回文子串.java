package algorithm_10_dp;

public class p52_m647回文子串 {
    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(j) == s.charAt(i)) {
                    if (s.charAt(j) == s.charAt(i) && (j - i < 3 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        res ++;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "abc";
        int res = countSubstrings(s);
        System.out.println(res);
    }
}
