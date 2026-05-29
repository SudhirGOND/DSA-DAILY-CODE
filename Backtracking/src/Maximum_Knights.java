


//public class Maximum_Knights {
//
//    static int max;// static global variable
//
//    static {
//        max = -1;
//    }
//
//    public static void main(String[] args) {
//
//        int n = 3;// matrix row/col number
//        char[][] board = new char[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                board[i][j] = '.';
//            }
//        }
//
//        nknight(board, 0, 0, 0);
//        System.out.println("MAX = " + max);
//    }
//
//    private static void nknight(char[][] board, int row, int col, int num) {
//
//        int n = board.length;
//
//        /// base case
//        if (row == n) {
//
//            if (num > max) max = num;
//
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(board[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//            return;
//        }
//
//
//        /// next cell logic
//        int nextRow = row;
//        int nextCol = col + 1;
//        if (nextCol == n) {
//            nextRow = row + 1;
//            nextCol = 0;
//        }
//
//        /// OPTION 1: place knight
//        if (isSafe(board, row, col)) {
//            board[row][col] = 'K'; /// filled
//            nknight(board, nextRow, nextCol, num + 1);
//            board[row][col] = '.'; /// BACKTRACK
//        }
//
//        /// OPTION 2: don't place knight
//        nknight(board, nextRow, nextCol, num);
//    }
//
//    public static boolean isSafe(char[][] board, int row, int col) {
//        int n = board.length;
//
//        //////2 up 1 right
//        int i = row - 2;
//        int j = col + 1;
//        if (i >= 0 && j < n && board[i][j] == 'K') return false;
//
//        //////2 up 1 left
//        i = row - 2;
//        j = col - 1;
//        if (i >= 0 && j >= 0 && board[i][j] == 'K') return false;
//
//        //////2 down 1 right
//        i = row + 2;
//        j = col + 1;
//        if (i < n && j < n && board[i][j] == 'K') return false;
//
//        //////2 down 1 left
//        i = row + 2;
//        j = col - 1;
//        if (i < n && j >= 0 && board[i][j] == 'K') return false;
//
//        //////1 up 2 right
//        i = row - 1;
//        j = col + 2;
//        if (i >= 0 && j < n && board[i][j] == 'K') return false;
//
//        //////1 down 2 right
//        i = row + 1;
//        j = col + 2;
//        if (i < n && j < n && board[i][j] == 'K') return false;
//
//        //////1 down 2 left
//        i = row + 1;
//        j = col - 2;
//        if (i < n && j >= 0 && board[i][j] == 'K') return false;
//
//        //////1 up 2 left
//        i = row - 1;
//        j = col - 2;
//        if (i >= 0 && j >= 0 && board[i][j] == 'K') return false;
//
//        return true;
//    }
//}

public class Maximum_Knights {

    static int max = -1;
    static int number = 5;

    public static void main(String[] args) {

        int n = 3; // matrix row/col number
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        nknight(board, 0, 0, 0); /// calling the recursive function
        System.out.println("MAX " + max );
    }


    private static void nknight(char[][] board, int row, int col, int num) {
        int n = board.length;

        /// BASE CASE
        if (row == n) {
            if (num == number) {
                // print board properly
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(board[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            max  = Math.max(num,max) ;
            return;  /// MUST RETURN HERE!
        }

        /// Try placing knight if position is safe
        if (safe(board, row, col)) {
            board[row][col] = 'K';

            if (col != n - 1)
                nknight(board, row, col + 1, num + 1);
            else
                nknight(board, row + 1, 0, num + 1);

            board[row][col] = '.'; /// backtracking
        }

        /// Move to next cell WITHOUT placing knight
        if (col != n - 1)
            nknight(board, row, col + 1, num);
        else
            nknight(board, row + 1, 0, num);
    }

    public static boolean safe(char[][] grid, int row, int col) {
        int n = grid.length;

        //// Knight move checks

        // 2 up, 1 right
        int i = row - 2, j = col + 1;
        if (i >= 0 && j < n && grid[i][j] == 'K') return false;

        // 2 up, 1 left
        i = row - 2; j = col - 1;
        if (i >= 0 && j >= 0 && grid[i][j] == 'K') return false;

        // 2 down, 1 right
        i = row + 2; j = col + 1;
        if (i < n && j < n && grid[i][j] == 'K') return false;

        // 2 down, 1 left
        i = row + 2; j = col - 1;
        if (i < n && j >= 0 && grid[i][j] == 'K') return false;

        // 1 up, 2 right
        i = row - 1; j = col + 2;
        if (i >= 0 && j < n && grid[i][j] == 'K') return false;

        // 1 down, 2 right
        i = row + 1; j = col + 2;
        if (i < n && j < n && grid[i][j] == 'K') return false;

        // 1 down, 2 left
        i = row + 1; j = col - 2;
        if (i < n && j >= 0 && grid[i][j] == 'K') return false;

        // 1 up, 2 left
        i = row - 1; j = col - 2;
        if (i >= 0 && j >= 0 && grid[i][j] == 'K') return false;

        return true;
    }

}
