package real.a;

import java.util.*;

/*
游游想知道，有多少个长度为n的排列满足任意两个相邻元素之和都不是素数。你能帮帮她吗？
我们定义，长度为n的排列值一个长度为n的数组，其中1到n每个元素恰好出现了一次。
输入描述
一个正整数n。
2\leq n \leq 10
输出描述
满足条件的排列数量。
示例1
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
复制
5
输出
复制
4
说明
共有以下 4 种合法排列：
[1,3,5,4,2]
[3,1,5,4,2]
[2,4,5,1,3]
[2,4,5,3,1]
*/
public class trip1排列统计 {


        private static int count = 0;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int result = getCount(n);
            System.out.println(result);
        }

        public static int getCount(int n) {
            List<Integer> nums = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++) {
                nums.add(i);
            }

            backtrack(nums, 0, n);
            return count;
        }

        private static void backtrack(List<Integer> nums, int start, int n) {
            if (start == n) {
                count++;
            } else {
                for (int i = start; i < n; i++) {
                    if (start == 0 || !isPrime(nums.get(start - 1) + nums.get(i))) {
                        swap(nums, start, i);
                        backtrack(nums, start + 1, n);
                        swap(nums, start, i);
                    }
                }
            }
        }

        private static void swap(List<Integer> nums, int i, int j) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }

        private static boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            }

            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }

            return true;
        }


}
