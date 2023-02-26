package algorithm_10_dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class p26_m139单词拆分 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (set.contains(s.substring(i, j)) && dp[i]) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[s.length()];

    }



    public static void main(String[] args) {
        List<String> wordDict= new ArrayList() {{
            add("leet");
            add("code");
        }};
        HashSet<String> set = new HashSet<>(wordDict);
        boolean res = wordBreak("leetcode", wordDict);
        System.out.println(res);
    }
}
