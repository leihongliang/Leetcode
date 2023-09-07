package real.a;

import java.util.*;
/*
游游有一个只包含'0'和'1'的字符串，他想知道这个字符串有多少个好子串？
一个字符串如果是"好串"，那么该字符串的所有前缀，'0'的数量严格大于'1'的数量。
输入描述
输入一个只包含'0'和'1'的字符串，长度不超过100000。
输出描述
输出一个整数，代表答案。
示例1
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
复制
100
输出
复制
3
说明
子区间 [2, 2], [2, 3], [3, 3] 组成的子串都是一个好串。
示例2
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
复制
10010
输出
复制
6
说明
子区间 [2, 2], [3, 3], [2, 3], [2, 4], [2, 5], [5, 5] 组成的子串是一个好串。
* */
public class trip4好串 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = s.length();
        int[] more = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                more[i + 1] = more[i] + 1;
            } else {
                more[i + 1] = more[i] - 1;
            }
        }
        PriorityQueue<Integer> q = new PriorityQueue<>(n, (a, b) -> b - a);
        long res = 0;
        for (int i = 1; i <= n; i++) {
            if (more[i] > more[i - 1]) {
                q.offer(more[i]);
            } else {
                while (!q.isEmpty() && q.peek() > more[i]) {
                    q.poll();
                }
            }
            res += q.size();
        }
        System.out.println(res);
    }
}