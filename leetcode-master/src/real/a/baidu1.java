package real.a;

import java.util.Arrays;
import java.util.Scanner;

/*
*
定义一个所有元素互不相等的数组的权值为最大值所在位置的下标和最小值所在位置的下标的差值。
例如，若最大值为a_i，最小值为a_j，则该数组的权值为|i - j|。
讨厌鬼现在有一个长度为n互不相等的数组a。他每次操作可以选择数组中相邻的数a_i和a_{i+1} (1 \leq i < n)，随后交换a_i和a_{i+1}。
讨厌鬼想知道使数组权值最大的最小操作数是多少。
输入描述
第一行一个整数n(1 \leq n \leq 10^5)。
第二行n个整数a_i(1 \leq a_i \leq 10^9)，保证数组元素互不相同。
输出描述
输出一个整数，表示最小操作数。
示例1
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
5
8 7 1 3 4
输出
2
说明
两次操作为，交换a_3和a_4，交换a_4和a_5
* */
public class baidu1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
//        int n = 5;
//        int[] arr = {8, 9, 3, 1, 4};

        int result = minimumOperations(arr);
        System.out.println(result);

        scanner.close();
    }

    private static int minimumOperations(int[] arr) {
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        int a = maxIndex + arr.length - 1 - minIndex;
        int b = arr.length - 1 - maxIndex + minIndex;
//        System.out.println(a);
//        System.out.println(b);

        return Math.min(a, b);
    }


}
