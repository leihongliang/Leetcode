package real.a;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class xiaomi2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] pairs = in.next().split(",");
        int n = pairs.length;
        int[][] tasks = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ss = pairs[i].split(":");
            int cost = Integer.parseInt(ss[0]);
            int need = Integer.parseInt(ss[1]);
            tasks[i][0] = cost;
            tasks[i][1] = need;
        }

        Arrays.sort(tasks, (a, b) -> {
            if (b[1] != a[1]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });
        int minPower = 0;
        long battery = 0;

        for (int i = 0; i < n; i++) {
            int power = tasks[i][1];
            int value = tasks[i][0];

            if (minPower < power) {
                battery += power - minPower;
                minPower = power;
            }
            minPower -= value;
        }
        System.out.println(battery > 4800 ? -1 : battery);

    }

}



