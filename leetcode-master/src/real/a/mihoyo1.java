package real.a;

/*
对于一个数组c，定义f(c)为c数组所有元素的总和。
现在给定两个长度为n的数组a,b，请你恰好删除一个数组a的元素或者一个数组b的元素，使得f(a)异或f(b)最大。
输入描述
第一行输入一个整数n。
第二行输入n个整数a_i。
第三行输入n个整数b_i。
输出描述
输出最大的异或和。
示例1
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
3
1 2 3
3 2 1
输出
5
说明
删除a数组的3。

* */

import java.util.Scanner;

public class mihoyo1 {


    public static int sum(int[] arr) {
        int s = 0;
        for (int x : arr) {
            s += x;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        sc.close();
        int sa = sum(a);
        int sb = sum(b);
        int max = sa ^ sb;

        for (int i = 0; i < n; i++) {
            int xa = (sa - a[i]) ^ sb;
            int xb = sa ^ (sb - b[i]);
            max = Math.max(max, Math.max(xa, xb));
        }

        System.out.println(max);
    }


}
