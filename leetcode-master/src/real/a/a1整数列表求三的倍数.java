package real.a;

import java.util.ArrayList;
import java.util.Scanner;

public class a1整数列表求三的倍数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp = 0;
        for (int i = 2; i < n + 1; i++) {
            dp = (dp + 3) % i;
        }
        System.out.println(dp + 1);
    }

    public static void main0(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int m=1;
        while(list.size()!=1){
            for (int i = 0; i < list.size(); i++) {
                if(m>3){
                    m=1;
                }
                if(m%3==0){
                    list.remove(i);
                    i--;
                }
                m++;
            }
        }
        System.out.println(list);
    }
}
