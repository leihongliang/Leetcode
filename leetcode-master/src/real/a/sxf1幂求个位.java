package real.a;

import java.util.Scanner;

public class sxf1幂求个位 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(powerMod(x, y));

    }
    public static int powerMod(int x, int y) {
        if (y == 0) {
            return 1;
        }
        if (y % 2 == 0) {
            int temp = powerMod(x, y / 2);
            return (temp * temp) % 10;
        } else {
            int temp = powerMod(x, y / 2);
            return (x * temp * temp) % 10;
        }
    }

}
