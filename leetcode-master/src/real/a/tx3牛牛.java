package real.a;

import java.util.Arrays;
import java.util.Scanner;

public class tx3牛牛 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=in.nextInt();
        }
        Arrays.sort(nums);

        if (n % 2==0){
            int a=0;
            int b=0;
            for (int i = 0; i < n/2-1; i++) {
                a+=nums[i];
            }
            for (int i = n/2; i < n; i++) {
                b+=nums[i];
            }
            System.out.println(b-a);
        }else{
            int a=0;
            int b=0;
            for (int i = 0; i < n/2; i++) {
                a+=nums[i];
            }
            for (int i = n/2; i < n; i++) {
                b += nums[i];
            }
            System.out.println(b-a);
        }
    }
}










