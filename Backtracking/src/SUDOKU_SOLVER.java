//public class SUDOKU_SOLVER {
//    public static void main(String[] args) {
//        /// given is the board of the sudoku
//        char[][] board = new char[9][9];
//        char[][] grid = new char[9][9];
//
//        solve(board, 0, 0, grid); //  grid me sab elements hain but we have to returnd into the same only
//
//
//
//
//        ///  copy back into the board
//
//        for (int i = 0; i < 9; i++) {
//
//            for (int j = 0; j < 9; j++) {
//                board[i][j] = grid[i][j];
//            }
//
//        }
//
//        ///return; // board
//
//    }
//
//
//    public static void solve(char[][] board, int row, int col, char[][] grid) {
//
//
//        //base case
//        if (row == 9) {
//            //copy the elements of board to grid
//            for (int i = 0; i < 9; i++) {
//                for (int j = 0; j < 9; j++) {
//                    grid[i][j] = board[i][j];
//
//                }
//            }
//
//            return;
//        }
//
//
//        if (board[row][col] != '.') {///  aage move
//            if (col != 8)
//                solve(board, row, col + 1, grid);
//            else solve(board, row + 1, 0, grid);
//
//        } else //  empty  hai to fill karo
//        {
//            for (char ch = '1'; ch <= '9'; ch++) { ///  firsr time loop of the character
//                if (validcheck(board, row, col, ch)) {
//                    board[row][col] = ch;// filled
//                    if (col != 8) solve(board, row, col + 1, grid);//pura row
//                    else solve(board, row + 1, 0, grid);//pura col
//                    board[row][col] = '.'; // backtracking == we get the  empty at last so we add the grid
//                }
//
//
//            }
//
//        }
//
//    }
//
//
//    private static boolean validcheck(char[][] board, int row, int col, int num) {
//        ///  here the char(int) num is converted into the integer
//
//        /// check the row
//        for (int j = 0; j < 9; j++) {
//            if (board[row][j] == num) return false;
//        }
//
//        for (int i = 0; i < 9; i++) {
//            if (board[i][col] == num) return false;
//        }
//        // check the 3X3 grid
//        int sRow = (row / 3) * 3;
//        int sCol = (col / 3) * 3;
//
//        for (int i = sRow; i < sRow + 3; i++) {
//            for (int j = sCol; j < sCol + 3; j++) {
//                if (board[i][j] == num) return false;
//
//            }
//        }
//        return true;
//    }
//
//
//}


///  without using the grid also we have to do like this





public class SUDOKU_SOLVER {
    static int check = 0;//// goood trick but for the new test case leetcode give wrong ans beacz it not initilise the check as zero


    /// checking that the board is filled
    public static void main(String[] args) {
        /// given is the board of the sudoku
        char[][] board = new char[9][9];

        solve(board, 0, 0);
//        check = 0;///// trick because leetcode checks only the function of the solve itself


    }


    public static void solve(char[][] board, int row, int col) {


        //base case
        if (row == 9) {

            check = 1; ///  board is filled properly
            return;
        }


        if (board[row][col] != '.') {///  aage move
            if (col != 8)
                solve(board, row, col + 1);
            else solve(board, row + 1, 0);

        } else //  empty  hai to fill karo
        {
            for (char ch = '1'; ch <= '9'; ch++) { ///  firsr time loop of the character
                if (validcheck(board, row, col, ch)) {
                    board[row][col] = ch;// filled
                    if (col != 8) solve(board, row, col + 1);//pura row
                    else solve(board, row + 1, 0);//pura col


                    /// //gjjjjjbbbbb  dimmaaaag
                    if (check == 1) return;

                    board[row][col] = '.'; // backtracking == we get the  empty at last so we add something phle
                }


            }

        }

    }


    private static boolean validcheck(char[][] board, int row, int col, int num) {
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

