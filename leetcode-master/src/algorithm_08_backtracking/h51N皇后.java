package algorithm_08_backtracking;

import java.util.*;

public class h51N皇后 {
    static List<List<String>> res = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        helper(n, 0, chessboard);
        return res;

    }
    // 每行中的每列
    public static void helper (int n, int row, char[][] chessboard){
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid (row, col, n, chessboard)){
                chessboard[row][col] = 'Q';
                helper(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    public static List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public static boolean isValid(int row, int col, int n, char[][] chessboard) {
        for (int i = 0; i < col; i++) {
            if (chessboard[row][i] == 'Q') return false;
        }
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q' ) return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1 ; i--, j++) {
            if (chessboard[i][j] == 'Q') return false;
        }
        return true;

    }

    public static void main(String[] args) {
        List<List<String>> res = solveNQueens(1);
        System.out.println(res);
    }
}
