package real.a;

import java.util.HashMap;
import java.util.Scanner;

public class a美团5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        long[] count = new long[n+1];
        count[0] = 0;
        int input;
        int sum = 0;
        int index = 1;
        for (int ignored : arr) {
            input = in.nextInt();
            sum = sum + k - input;
            count[index++] = sum;
        }

        System.out.println(maxD(count));

    }
    public static long maxD(long[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            int value = map.getOrDefault(num, -1);
            if (value != -1) {
                max = Math.max(max, i - value);
            } else {
                map.put(num, i);
            }

        }
        return max;
    }


}



