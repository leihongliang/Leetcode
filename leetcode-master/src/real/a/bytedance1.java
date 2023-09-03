package real.a;

import java.util.Arrays;
import java.util.Scanner;


public class bytedance1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        long total = 0;
        for (int i = 1; i < n; i++) {
            total += Math.abs(arr[i] - arr[i - 1]);
        }
        if (n == 1) {
            System.out.println(total);
            return;
        }
        System.out.print((total - Math.abs(arr[1] - arr[0])) + " ");
        for (int i = 1; i < n - 1; i++) {
            int m = arr[i];
            int l = arr[i - 1];
            int r = arr[i + 1];
            long oldSum = (long) Math.abs(m - l) + Math.abs(m - r);
            m = (l + r) / 2;
            long newSum = (long) Math.abs(m - l) + Math.abs(m - r);
            System.out.print((total + (newSum - oldSum)) + " ");
        }
        System.out.println(total - Math.abs(arr[n - 1] - arr[n - 2]));
    }

}



