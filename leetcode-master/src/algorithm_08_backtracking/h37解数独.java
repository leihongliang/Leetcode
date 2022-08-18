package algorithm_08_backtracking;

import java.util.Arrays;

public class h37解数独 {
    public static void solveSudoku(char[][] board) {
        helper(board);
    }
    public static boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char c = '1'; c <= '9'; c++) {
                    if (isValid(i, j, c, board)){
                        board[i][j] = c;
                        if (helper(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return false;
    }
    // check before putting in
    public static boolean isValid(int row, int col, char val, char[][] board) {
        // check the same row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == val) return false;
        }
        // check the same col
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) return false;
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};

        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}
