package algorithm_01_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class rxm2两个有序数组合并 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[m + n];
        int[] b = new int[n];
        for (int i = 0; i < m; i++) a[i] = sc.nextInt();
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();
        while (m > 0 || n > 0) {
            if (m == 0){
                a[m + n - 1] = b[--n];
            }else if (n == 0){
                a[m + n - 1] = a[--m];
            }else if (a[m - 1] >= b[n - 1]) {
                a[m + n - 1] = a[--m];
            }else {
                a[m + n - 1] = b[--n];
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
