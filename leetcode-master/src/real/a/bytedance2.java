package real.a;

import java.util.Arrays;
import java.util.Scanner;


public class bytedance2 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            // 读取输入
            int xA = sc.nextInt();
            int yA = sc.nextInt();
            int xB = sc.nextInt();
            int yB = sc.nextInt();
            int xp = sc.nextInt();
            int yp = sc.nextInt();
            // 计算中点坐标
            int xM = (xA + xB) / 2;
            int yM = (yA + yB) / 2;
            // 计算斜率
            double k;
            if (xM == xp) {
                // 斜率不存在
                System.out.println("inf");
            } else {
                // 斜率存在
                k = (double) (yM - yp) / (xM - xp);
                System.out.println(k);
            }
        }


}



