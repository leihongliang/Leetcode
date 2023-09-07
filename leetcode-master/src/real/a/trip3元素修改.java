package real.a;

import java.util.*;
/*
* 用java写一下这道题
游游拿到了一个数组，她每次操作可以使得一个元素加1，另一个元素减1。
游游希望最终数组的每个元素大小都在[l,r]范围内，她想知道自己最少多少次操作可以达成目标？
输入描述
第一行输入一个正整数t，代表用例的组数。
对于每组用例：
第一行输入三个正整数n,l,r。
第二行输入n个正整数a_i，代表游游拿到的数组。
保证所有的n的总和不超过200000。
输出描述
输出t行，每行一个整数，含义如下：
如果无法用有限次数的操作次数使得每个元素大小都在[l,r]范围内，请输出-1。
否则输出一个整数，代表最少的操作次数。
示例1
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
2
2 3 5
1 2
3 4 6
3 6 5
输出
-1
1
说明
第一组用例：显然无法用有限次数的操作使得所有元素范围都在[3,5]之间。
第二组用例：使第一个数加1，第三个数减1即可，数组变成[4,6,4]，满足所有元素不小于4，不大于6。
* */
public class trip3元素修改 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            long l = scanner.nextLong();
            long r = scanner.nextLong();

            List<Long> nums = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nums.add(scanner.nextLong());
            }

            long sum = 0;
            for (long num : nums) {
                sum += num;
            }

            long sumL = n * l;
            long sumR = n * r;

            if (sum < sumL || sum > sumR) {
                System.out.println(-1);
                continue;
            }

            long sum1 = 0;
            long sum2 = 0;
            for (int i = 0; i < n; i++) {
                if (nums.get(i) < l) {
                    sum1 += (l - nums.get(i));
                } else if (nums.get(i) > r) {
                    sum2 += (nums.get(i) - r);
                }
            }

            System.out.println(Math.max(sum1, sum2));
        }
    }

}
