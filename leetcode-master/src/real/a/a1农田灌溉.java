package real.a;

import java.util.Scanner;

public class a1农田灌溉 {
    static int solution(int[][] cropField) {
        int n = cropField.length, m = cropField[0].length;

        int[] maxRows = new int[n];
        int[] maxCols = new int[m];

        int sum = 0;
        // 找最大行
        for (int i = 0; i < n; i++) {
            int curRow = 0;
            for (int j = 0; j < m; j++) {
                curRow += cropField[i][j];
            }
            maxRows[i] = curRow;
            sum += curRow;
        }

        //找最大列
        for (int j = 0; j < m; j++) {
            int curCol = 0;
            for (int i = 0; i < n; i++) {
                curCol += cropField[i][j];
            }
            maxCols[j] = curCol;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // i行和j列
                res = Math.max(res, maxRows[i] + maxCols[j] - cropField[i][j] + sum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int cropField_rows = 0;
        int cropField_cols = 0;
        cropField_rows = in.nextInt();
        cropField_cols = in.nextInt();

        int[][] cropField = new int[cropField_rows][cropField_cols];
        for(int cropField_i=0; cropField_i<cropField_rows; cropField_i++) {
            for(int cropField_j=0; cropField_j<cropField_cols; cropField_j++) {
                cropField[cropField_i][cropField_j] = in.nextInt();
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }


//        res = new Solution().calculateMaxTotalYie(cropField);
//        System.out.println(String.valueOf(res));


//        int[][]cropField ={
//                {2,3,1,4},
//                {1,2,0,3},
//                {4,2,1,7},
//                {3,1,4,2},
//        };
        res = solution(cropField);
        System.out.println(res);
    }
}
