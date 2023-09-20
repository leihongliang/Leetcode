package real.a;

import java.util.*;
/*
1、

丢失报文的位置

某通信系统持续向外发送报文，使用数组nums保存n个最近发送的报文，用于在报文未达到对端的情况下重发。报文使用序号sn表示，序号sn按照报文发送顺序从小到大排序，相邻报文sn不完全连续且有可能相同。报文使用循环覆盖的方式保存，即nums数组填满后，从头开始保存新的报文。假设需要重发序号为sn的报文。请找出序号为sn的报文在数组中的开始位置和结束位置。

输入
第一行输入:数组nums的大小n，取值范围[0,10000]
第二行输入:数组中的所有报文的序号sn，sn取值范围[0,100000]。
第三行输入:需要重发的报文序号sn，取值范围[0,100000]

输出
start end
说明：start和end代表需要重发的报文序号sn在数组中的起始下标和结束下标

样例1
输入：
7
0 0 1 2 2 5 6
1
输出：
2 2
解释：
nums数组大小为7
保存了7个报文，sn分别是0 0 1 2 2 5 6
sn为1的报文在数组中仅有1个，下标是2，因此输出2 2

样例2
输入：
7
0 0 1 2 2 5 6
2
输出：
3 4
解释：
nums数组大小为7
保存了7个报文，sn分别是0 0 1 2 2 5 6
sn为2的报文在数组中有2个，下标分别是3,4，因此输出3 4

样例3
输入：
7
4 4 7 8 2 3 4
4
复制输出：
6 1
解释：
nums数组大小为7
保存了7个报文，sn分别是4 4 7 8 2 3 4
sn为4的报文在数组中有3个，下标分别是0，1，6，说明数组存在记录满了从头开始记录的情况，输出6 1

样例4
复制输入：
7
4 4 7 8 2 3 4
6
复制输出：
-1 -1
解释：
nums数组大小为7
保存了7个报文，sn分别是4 4 7 8 2 3 4
数组中不存在sn为6的报文，因此输出-1 -1

样例5
复制输入：
5
5 5 5 5 5
5
复制输出：
0 4
解释：
nums数组大小为5
保存了5个报文，sn分别是5 5 5 5 5
数组中所有报文sn都是5，这种情况下认为0是start，4是end，输出0 4

* */

public class huawei1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int sn = in.nextInt();
        for (int i = 0; i < n; i++) {
            if (arr[i] != sn) continue;
            int end = i;
            int start = i;
            while (arr[end + 1 >= n ? 0: end + 1] == arr[i]) {
                end = (end + 1) >= n ? 0: end + 1;
                if (end == i) {
                    System.out.println(0 + " " + (n - 1));
                    return;
                }
            }
            while (arr[start - 1 < 0 ? n - 1: start - 1] == arr[i]) {
                start = (start - 1) < 0 ? n - 1: start - 1;
            }
            System.out.println(start + " " + end);
            return;
        }
        System.out.println(-1 + " " + -1);
    }

    //提交版本
    public static void main0(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int sn = in.nextInt();
        for (int i = 0; i < n; i++) {
            if (arr[i] != sn) continue;
            int end = i;
            int start = i;
            while (true) {
                int next = end + 1;
                if (next >= n) {
                    next = 0;
                }

                if (arr[next] == arr[i]) {
                    end = next;
                    if (end == i) {
                        System.out.println(0 + " " + (n - 1));
                        return;
                    }
                } else {
                    break;
                }
            }
            while (true) {
                int prev = start - 1;
                if (prev < 0) {
                    prev = n - 1;
                }

                if (arr[prev] == arr[i]) {
                    start = prev;
                } else {
                    break;
                }
            }

            System.out.println(start + " " + end);
            return;
        }
        System.out.println(-1 + " " + -1);
    }

    //0.85版本
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int sn = scanner.nextInt();
        int start = -1;
        int end = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == sn) {
                if (start == -1) {
                    start = i;
                }
                end = i;
            }
        }
        System.out.println(start + " " + end);
    }
}
