package real.a;

import java.math.BigInteger;
import java.util.Scanner;

/*
已知山体上的雪球向下滚动时，雪球每向下滚动1的距离，体积会膨胀x倍。
例如，海拔高度为2的、初始大小为1雪球，当它滚到海拔高度为0的地面时，若x=5其大小会变成1*5*5=25。
现在每个海拔为i的高度都生成了a_i个大小为1的雪球。当它们全部滚动道地面时，请你求出所有雪球的大小总和。答案对{10^9 + 7} 取模。
输入描述
在第一行中，给出山的高度和雪球增加的程度。
在第二行到  行表示在山上生成的雪球数量，其中第  行的数字表示在高度为i处制成的雪球的数量{a_i}。

输出描述
输出从山上滚下的所有雪球的大小总和，答案对{10^9 + 7} 取模。
示例1
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
4 5
1
3
2
4
输出
2830
说明
通过累加计算全部雪球的大小总和为{1 × 5 + 3 × 25 + 2 × 125 + 4 × 625 =2830}

示例2
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
3 1
1
2
3
输出
6
说明
通过累加计算全部雪球的大小总和为1 × 1 + 2 × 1 + 3 × 1 =6
* */
public class hema2 {
    public static void main0(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int x = sc.nextInt();
        int res = 0;
        int size = x;
        for (int i = 0; i < h; i++) {
            int num = sc.nextInt();
            res += num * size;
            size *= x;
        }
        res %= 1000000007;
        sc.close();
        System.out.println(res);
    }
    //快速幂算法
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int x = sc.nextInt();
        int res = 0;
        int size = x;
        int mod = 1000000007;

        for (int i = 0; i < h; i++) {
            int num = sc.nextInt();
            res = (int) ((res + (long) num * size) % mod);
            size = (int) ((long) size * x % mod);
        }

        sc.close();
        System.out.println(res);
    }
}
