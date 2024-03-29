package real.a;

import java.io.*;
import java.util.Scanner;
/*
* 差错控制是计算机网络数字传输中重要的一环。
假设传输的数据以一个长度为n的二进制位串S表示，牛牛定义了一种新的校验和，他将S中所有长度为k的子串进行异或，得到的新串就是他定义的校验和。例如，对于位串000111来说，当
k为2时，所有的长度为2的子串为00,00,01,11,11将他们对应的位异或，得到的校验和为01。

然而他定义的校验和实际上难以进行好的差错控制，为了验证，牛牛决定计算在上述定义的方式下，有多少个不同的"长度为n"且"与S不同的二进制位串"可以产生"与S相同"的校验和。
子串的定义：一个串中任意个连续的字符组成的子序列。
显然最终的结果与S无关，由于答案可能过大，请输出结果对
10^9+7取模后的结果。
输入描述:
第一行一个正整数T，代表测试组数。
接下来T行每行以空格分隔的两个正整数,n,k。
输出描述:
输出T行，每行一个整数代表答案。
示例1
输入
3
1 1
2 1
2 2
输出
0
1
0
说明
长度为1的S可能为 0 或者1，可以计算得到：不存在长度为1的且和S校验和的相同的串；
长度为2的S可能为00,11,01,10，对他们长度为1的子串进行异或，比如S为00的时候，校验和为0，11的校验与它相同。比如
S为01的时候，校验和为1，10的校验与它相同；
长度为2的S可能为00,11,01,10，对他们长度为2的子串进行异或，比如S为00的时候，校验和为00，不存在长度为2的且和
S校验和的相同的串。
*
* */
import java.util.Scanner;

public class tx4校验和 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt(); // 测试组数
        int T = 1; // 测试组数
        int mod = 1000000007; // 取模的数
        for (int t = 0; t < T; t++) {
//            int n = sc.nextInt(); // S的长度
//            int k = sc.nextInt(); // 子串的长度
            int n = 2; // S的长度
            int k = 2; // 子串的长度
            int[] xor = new int[1 << k]; // 存储所有长度为k的子串的异或值
            for (int i = 0; i < xor.length; i++) {
                xor[i] = i ^ (i >>> 1); // 计算每个子串的异或值，使用格雷码的方法
            }
            int ans = 0; // 答案
            for (int i = 0; i < xor.length; i++) {
                if (xor[i] == n) { // 如果子串的异或值和S相同，答案加一
                    ans++;
                }
            }
            System.out.println(ans % mod); // 输出答案对mod取模后的结果
        }
        sc.close();
    }
}








