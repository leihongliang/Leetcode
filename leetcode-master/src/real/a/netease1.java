package real.a;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class netease1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int MOD = 1000000007;
        long result = 0;

        // 遍历数组元素
        for (int i = 0; i < n; i++) {
            // 计算以当前元素为结尾的子序列的和
            for (int j = i; j < n; j++) {
                result = (result + arr[j]) % MOD;
            }
        }

        System.out.println(result);
    }



}



