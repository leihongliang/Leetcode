package real.a;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
/*


* */

public class tx22奇偶操作数组 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        PriorityQueue<Integer> h = new PriorityQueue<>((a, b) -> {
            int dis1 = change(a) - a;
            int dis2 = change(b) - b;
            return dis1 - dis2;
        });
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            h.add(arr[i]);
            sum += arr[i];
        }
        for (int i = 0; i < k; i++) {
            int cur = h.poll();
            int next = change(cur);
            sum += next - cur;
            h.add(next);
        }
        System.out.println(sum);
    }

    public static int change(int num) {
        if (num % 2 == 0) {
            return num * 2 + 1;
        } else {
            return num * 2;
        }
    }
}








