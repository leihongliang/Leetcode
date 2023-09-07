package real.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class trip1排列非素数 {

        //判断一个数是否是素数
        public static boolean isPrime(int n) {
            if (n < 2) return false;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) return false;
            }
            return true;
        }

        //找出所有的素数
        public static List<Integer> findPrimes(int n) {
            List<Integer> primes = new ArrayList<>();
            for (int i = 2; i <= n * 2; i++) {
                if (isPrime(i)) primes.add(i);
            }
            return primes;
        }

        //用一个数组记录每个元素的邻居是否是素数
        public static boolean[][] help(int n, List<Integer> primes) {
            boolean[][] neighborPrime = new boolean[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (primes.contains(i + j)) {
                        neighborPrime[i][j] = true;
                        neighborPrime[j][i] = true;
                    }
                }
            }
            return neighborPrime;
        }

        //用回溯法遍历所有可能的排列，判断是否满足条件
        public static int backtrack(int[] perm, int index, boolean[] used, boolean[][] neighborPrime) {
            //如果已经到达最后一个元素，检查是否满足条件
            if (index == perm.length - 1) {
                if (!neighborPrime[perm[index - 1]][perm[index]]) return 1;
                else return 0;
            }
            //否则，尝试每个未使用的元素
            int count = 0;
            for (int i = 1; i < used.length; i++) {
                //如果该元素未使用，并且与前一个元素之和不是素数，可以放入排列中
                if (!used[i] && !neighborPrime[perm[index - 1]][i]) {
                    perm[index] = i;
                    used[i] = true;
                    //递归地继续生成排列
                    count += backtrack(perm, index + 1, used, neighborPrime);
                    //回溯，恢复状态
                    used[i] = false;
                }
            }
            return count;
        }

        //主函数，输入输出
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            sc.close();
            List<Integer> primes = findPrimes(n);
            boolean[][] neighborPrime = help(n, primes);
            int[] perm = new int[n];
            boolean[] used = new boolean[n + 1];
            int count = 0;
            //从每个元素开始生成排列
            for (int i = 1; i <= n; i++) {
                perm[0] = i;
                used[i] = true;
                count += backtrack(perm, 1, used, neighborPrime);
                used[i] = false;
            }
            System.out.println(count);
        }


}
