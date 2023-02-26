package real.a;

import java.util.Scanner;

public class a京东小红吃药 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        String b = in.nextLine();
        int[] bing=new int[n];
        for (int i = 0; i < n; i++) {
            if (b.charAt(i)=='1'){
                bing[i]=1;
            }
        }
        int m = in.nextInt();
        int[][] nums=new int[m][n];
        in.nextLine();
        for (int i = 0; i < m; i++) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            for (int j = 0; j < n; j++) {
                if (s1.charAt(j)=='1'){
                    nums[i][j]=1;
                }
                if (s2.charAt(j)=='1'){
                    nums[i][j]=-1;
                }
            }
        }
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int idx = in.nextInt()-1;
            for (int j = 0; j <n ; j++) {
                if (nums[idx][j]==1){
                    bing[j]=0;
                }
                if (nums[idx][j]==-1){
                    bing[j]=1;
                }
            }
            int res=0;
            for (int k = 0; k < n; k++) {
                if (bing[k]==1){
                    res++;
                }
            }
            System.out.println(res);
        }

    }

}
