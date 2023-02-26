package algorithm_09_greedy;


import java.util.Arrays;

public class test {

    public static int[][] snake(int n) {
        int[][] res = new int[n][n];
        int l = 0;
        int r = n -1;
        int t = 0;
        int b = n -1;
        int num = 1;
        while ( num <= n*n) {
            for ( int i = t ; i <= b; i++) {
                res[i][l] = num++;
            }
            l++;
            for ( int i = l; i <= r; i++) {
                res[b][i] = num++;
            }
            b--;
            for ( int i = b ; i >= t; i--) {
                res[i][r] = num++;
            }
            r--;
            for ( int i = r ; i >= l; i--) {
                res[t][i] = num++;
            }
            t++;
        }
        return res;

    }
    public static void main(String[] args) {
        int[][] res = snake(4);
        System.out.println(Arrays.toString(res));
    }

}
