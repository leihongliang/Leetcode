package real.a;

import java.util.Scanner;

public class a多益 {
    public static void main(String[] args) {
        int num = 90;
        int tmp = 2;
        StringBuffer res=  new StringBuffer();
        res.append(num);
        res.append("=");
        while (num > 1){
            if (num % tmp == 0){
                res.append(tmp);
                num /= tmp;
                if (num > 1) {
                    res .append("*");
                }
            }else {
                tmp++;
            }
        }
        System.out.println(res.toString());
    }

}
