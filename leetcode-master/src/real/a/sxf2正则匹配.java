package real.a;

import java.util.Scanner;
/*
* 平台运行过程中出现异常时一般会将信息记录在后台日志文件中，定位问题时通常使用关键字进行过滤。正则表达式具备很强大的文本匹配功能，能够快速高效地处理文本。常见元字符为:
^：匹配字符串开头。
$：匹配字符串结尾。
.：匹配任意字符。
*：匹配前面的字符零次或多次。
+：匹配前面的字符一次或多次。
?：匹配前面的字符零次或一次。

给定一个输入字符串s和一个字符模式 p，s和p的长度均在100以内，
要求实现一个支持'.'和'*'的正则表达式匹配。字符模式必须能够完全匹配输入字符串。
如果匹配成功返回1，匹配失败返回0
请设计一个时间复杂度为 O(mn) 或更优的算法来解决这个问题。如果使用内置正则库得0分。
* */
public class sxf2正则匹配 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        boolean result = isMatch(a, b);
        System.out.println(result ? 1 : 0);
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }

}
