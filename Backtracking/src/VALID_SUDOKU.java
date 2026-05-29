public class VALID_SUDOKU {

    public static void main(String[] args) {
        System.out.println("Given : Board and the Elements Inserted already:");
//        int[][] board = {{1, 2, 3, 4, 4}, {2, 3, 4, 5, 6}};
//        valid(board);

    }

    public boolean validSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue; // partially filled with the integers char**
                char num = board[i][j];//cell ka number
                board[i][j] = '.'; //  wahan pe . lagaye
                if (validcheck(board, i, j, num) == false) return false;
                board[i][j] = num; ///  backtracking the codes
            }
        }
        return true;
    }

    public boolean validcheck(char[][] board, int row, int col, int num) {
///  here the char(int) num is converted into the integer

        /// check the row

        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // check the 3X3 grid

        int sRow = (row / 3) * 3;
        int sCol = (col / 3) * 3;

        for (int i = sRow; i < sRow + 3; i++) {
            for (int j = sCol; j < sCol + 3; j++) {
                if (board[i][j] == num) return false;

            }
        }


        return true;
    }


}


