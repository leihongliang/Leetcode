package real.a;


import java.util.Scanner;

public class futu1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] p = new double[n];
        double[] q = new double[n];
        double ans = 0;
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextDouble();
            if (p[i] > 0.5) {
                q[i] = 1;
            } else if (p[i] < 0.5) {
                q[i] = 0;
            } else {
                q[i] = Math.random();
            }
            ans += p[i] * q[i] + (1 - p[i]) * (1 - q[i]);
        }
        System.out.printf("%.4f\n", ans);
        sc.close();
    }
}



