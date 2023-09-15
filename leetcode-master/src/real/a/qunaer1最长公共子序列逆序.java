package real.a;

import java.util.Scanner;
/*
* 输入两个字符串，求两个字符串的最长公共子序列，并将得到的子序列逆序输出
示例1
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
复制
"abcde","ace"
输出
复制
"eca"
* */
public class qunaer1最长公共子序列逆序 {
        public static String reverseString(String s) {
            char[] chars = s.toCharArray();
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            return new String(chars);
        }

        public static String maxSubsequenceAndReverse(String string1, String string2) {
            int m = string1.length();
            int n = string2.length();

            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            int length = dp[m][n];
            char[] result = new char[length];
            int i = m, j = n;

            while (i > 0 && j > 0) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    result[length - 1] = string1.charAt(i - 1);
                    i--;
                    j--;
                    length--;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }

            return new String(result);
        }

        public static void main(String[] args) {
            String text1 = "abcde";
            String text2 = "ace";
            String result = maxSubsequenceAndReverse(text1, text2);
            String reversedResult = reverseString(result);
            System.out.println(reversedResult);
        }

}
