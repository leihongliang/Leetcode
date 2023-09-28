package real.a;

import java.util.Scanner;

/*
小红拿到了一个数列，数列的前几项是：{1,2,4,5,10,11,22,……}
这个数列的规律是：
第一个数是1。
从第二个数开始，第偶数项比前一个数多1。第奇数项为前一个数乘以2。
小红想知道，这个数列的第 n 个数是多少？由于答案可能过大，请对1000000007取模。
输入描述
一个正整数 n

输出描述
一个正整数，代表数列的第 n 项对  取模的值。

示例1
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
2
输出
2
说明
数列的第2项为2

示例2
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
8
输出
23
说明
数列的第8项为23
* */
public class hema1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        long result = calculateNthNumber(n);
        System.out.println(result);
    }

    public static long calculateNthNumber(int n) {
        if (n == 1) {
            return 1;
        }

        int pre = 1;
        int cur = 2;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 1) {
                cur = pre * 2;
            }
            else {
                cur = pre + 1;
            }

            cur %= 1000000007;
            //更新前一项的值为当前项的值
            pre = cur;
        }
        //返回最终的结果cur
        return cur;
    }
}
