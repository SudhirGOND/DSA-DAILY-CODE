public class N_QUEENS {


    public static void main(String[] args) {

        int n = 4;//given

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        nqueen(board, 0);
    }

    private static void nqueen(char[][] board, int row) {


        int n = board.length;

        if (row == n) { ////  you reached at the last row
            //print the matrix board
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;

        }
        for (int j = 0; j < n; j++) {

            if (Safe(board, row, j)) {
                board[row][j] = 'Q';
                nqueen(board, row + 1);
                board[row][j] = '.';////backtracking

            }
        }

    }

    private static boolean Safe(char[][] board, int row, int col) {
        int n = board.length;
        //// /  ye bhi given hai ki ek row mei ek queen hogi
        // Check column (only above the current row)
        int i = 0;
        while (i < row) {
            if (board[i][col] == 'Q') return false;
            i++;
        }

        // Check diagonal north-east (upper-right)
        i = row - 1;
        int j = col + 1;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }

        // Check diagonal north-west (upper-left)
        i = row - 1;
        j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }


        /// //// hum lolg ko pata hai ki current row k niche koi queen nhi hogi
//        // Check diagonal south-east (lower-right)
//        i = row + 1;
//        j = col + 1;
//        while (i < n && j < n) {
//            if (board[i][j] == 'Q') return false;
//            i++;
//            j++;
//        }
//
//        // Check diagonal south-west (lower-left)
//        i = row + 1;
//        j = col - 1;
//        while (i < n && j >= 0) {
//            if (board[i][j] == 'Q') return false;
//            i++;
//            j--;
//        }

        return true;
    }

}