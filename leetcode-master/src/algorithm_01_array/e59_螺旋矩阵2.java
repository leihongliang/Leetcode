package algorithm_01_array;
import java.util.Arrays;

public class e59_螺旋矩阵2 {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int l = 0;
        int r = n -1;
        int t = 0;
        int b = n -1;
        int num = 1;
        while ( num <= n*n) {
            for ( int i = l ; i <= r; i++) {
                res[t][i] = num++;
            }
            t++;
            for ( int i = t ; i <= b; i++) {
                res[i][r] = num++;
            }
            r--;
            for ( int i = r ; i >= l; i--) {
                res[b][i] = num++;
            }
            b--;
            for ( int i = b ; i >= t; i--) {
                res[i][l] = num++;
            }
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = generateMatrix(3);
        System.out.println(Arrays.toString(nums[0]));
        System.out.println(Arrays.toString(nums[1]));
        System.out.println(Arrays.toString(nums[2]));
    }
}

