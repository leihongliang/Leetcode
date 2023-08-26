package real.a;

import java.util.Scanner;

public class a美团1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int m= in.nextInt();
        long[] price=new long[m];
        for (int i = 0; i < n; i++) {
            long total = in.nextInt();
            long sum = in.nextInt();
            long avg = (sum + total - 1) / total;
            for (int j = 0; j < total - 1; j++) {
                int index= in.nextInt()-1;
                price[index]+=avg;
            }
            int j = 0;
            while (j < total - 1) {
                int idx = in.nextInt() - 1;
                price[idx] += avg;
                j++;
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.print(price[i]+" ");
        }
    }
}
