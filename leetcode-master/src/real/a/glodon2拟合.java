package real.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
小丽正在捏橡皮泥。小丽想要挑战让她捏出的泥像能和她参考的物品一模一样。捏完发现好像比参考物小了一点，于是打算拆散后重新组装。小丽的泥像由n个组件组成，每个组件都可以随意塑形，所以我们可以只用大小来描述每个组件，这n个组件的大小分别为a1,a2, ..., an。经过小丽观察，参考物也可以用n个组件来组合而成，这n个组件大小分别为b1,b2, ..., bn。小丽发现她们实际上可以用可重复的集合来描述，泥像A = {a1,a2,..., an}，参考物B = {b1,b2, ..., bn}。小丽发现目前A ≠ B，但是小丽有一次改变的机会，从这n个泥像组件中选出任意多个，给它们依次贴一些新的橡皮泥上，即从{1,2, ..., n}中选出子集I = {I1,I2, ..., Ik}，使得a_I1,a_I2,..., a_In均增加1，即a_Ij = a_Ij + 1，得到新的描述泥像的集合, 小丽想知道，仅经过这一次变化是否能让A' = B



输入描述
第一行一个整数T，表示有T组测试。
对于每组测试而言：
第一行1个整数n，表示泥像和参考物组件数量。
第二行n个整数a1 a2...an 。表示泥像组件。
第三行n个整数b1 b2...bn。表示参考物组件。
对于100%的数据，1≤n≤10000，1≤T≤10，1≤ai,bi≤10000
输出描述
 对于每组测试一行Yes或者No表示能够满足要求或者无法满足要求。


样例输入
2
3
1 2 3
2 2 3
4
1 2 1 2
1 1 4 3

样例输出
Yes
No

提示
对于第一组测试，把第1个数增加1即可。
对于第二组测试，无法通过增加1把2变成4，没有任何办法使得转换后A' = B
* */

public class glodon2拟合 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int T = scanner.nextInt();
        int T = 1;

        for (int t = 0; t < T; t++) {
//            int n = scanner.nextInt();
//            int[] a = new int[n];
//            int[] b = new int[n];
//
//            for (int i = 0; i < n; i++) {
//                a[i] = scanner.nextInt();
//            }
//
//            for (int i = 0; i < n; i++) {
//                b[i] = scanner.nextInt();
//            }
            int[] a = {1,2,1,2};
            int[] b = {1,1,4,3};

            boolean canTransform = canTransform(a, b);

            if (canTransform) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean canTransform(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            if ((b[i] - a[i] != 0) && (b[i] - a[i] != 1)) {
                return false;
            }
        }
        return true;
    }
}
