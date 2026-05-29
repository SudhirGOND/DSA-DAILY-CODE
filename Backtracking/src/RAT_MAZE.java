//
//public class RAT_MAZE {
//


/// /this is the code for the count the ways

//    public static void main(String[] args) {
//
//        int row = 3;
//        int col = 3;
//
//
//        int count = maze(1, 1, row, col);
//        System.out.println(count);
//
//    }
//
//    // starting col// end col // sc//ec
//    private static int maze(int sr, int sc, int er, int ec) {
//
//        if (sr > er || sc > ec) return 0;
//        if (sr == er && sc == ec) return 1;
//
//        int downways = maze(sr + 1, sc, er, ec);
//        int rightways = maze(sr, sc + 1, er, ec);
//
//
//        return downways + rightways;
//    }
//
//}


//public class RAT_MAZE {
//
//    /// // print  the paths
//    public static void main(String[] args) {
//        //given the size of the matrix
//        int row = 3;
//        int col = 3;
//
//        String s = "";
//        pathPrint(1, 1, row, col, s);
//
//
//    }
//
//    private static void pathPrint(int sr, int sc, int er, int ec, String s) {
//
//
//        if (sr > er || sc > ec) return;
//        if (sr == er && sc == ec) {
//
//            System.out.println(s);////printing the string t every level if the recursion
//            return;
//        }
//
//        pathPrint(sr + 1, sc, er, ec, "D"+s);////row+1 === downways
//        pathPrint(sr, sc + 1, er, ec, "R"+s );///col+1 === rightways
//
//    }
//}
//


/// // going to feel the code of the backtracking at 4D RAT_MAZE == (L,R,D,U  alll fouur)
/// / gives the infinite answers
//
//public class RAT_MAZE {
//
//    /// // print  the paths
//    public static void main(String[] args) {
//        //given the size of the matrix
//        int row = 2;
//        int col = 2;
//
//        String s = "";
//        pathPrint(1, 1, row, col, s);
//
//
//    }
//
//
//    private static void pathPrint(int sr, int sc, int er, int ec, String s) {
//
//
//        if(sr<1 ||  sc< 1) return;
//
//        if (sr > er || sc > ec) return;
//        if (sr == er && sc == ec) {
//
//            System.out.println(s);////printing the string t every level if the recursion
//            return;
//
//
//        }


/// /// wrong style of approaching thee 4D  because  if rat already moved
/// ///  it can also repeat the old way


/// /        pathPrint(sr + 1, sc, er, ec, "D" + s);////row+1 === downways
/// /
/// /        pathPrint(sr, sc + 1, er, ec, "R" + s);///col+1 === rightways
/// /
/// /        /// go left
/// /
/// /        pathPrint(sr,sc-1,er,ec,s+"L");
/// /
/// /        ////go up
/// /
/// /        pathPrint(sr-1, sc,er,ec,s+"U");
//
//
//
//    }
//
//}
//
//


//public class RAT_MAZE {
//
//    /// // print  the paths
//    public static void main(String[] args) {
//        //given the size of the matrix
//        int row = 3;
//        int col = 3;
/// //  we made a boolean type matrix that stored the visited info in the form of TRUE  of FALSE
//
//        boolean[][] visited = new boolean[row][col];  //  by default -->  false stored
//
//        String s = "";
//        pathPrint(0, 0, row-1, col-1, s, visited);
//    }
//
//    private static void pathPrint(int sr, int sc, int er, int ec, String s,boolean[][] visited) {
//        if (sr < 0 || sc < 0) return;
//        if (sr > er || sc > ec) return;
//
//        if(visited[sr][sc] == true) return;// if visited then the place should be true;
//        if (sr == er && sc == ec) {
//
//            System.out.println(s);////printing the string t every level if the recursion
//            return;
//
//
//        }
//
//        visited[sr][sc] = true;
//        pathPrint(sr + 1, sc, er, ec, s+"D",visited);////row+1 === downways
//
//        pathPrint(sr, sc + 1, er, ec, s+"R",visited);///col+1 === rightways
//        /// go left
//        pathPrint(sr, sc - 1, er, ec, s + "L",visited);
//        ////go up
//        pathPrint(sr - 1, sc, er, ec, s + "U",visited);
//        /// backtracking se was false bna denge
//        visited[sr][sc] =  false;
//
//    }
//
//}
//
//


/// // root in the maze in which there are certain  ways are blocked means ==   0 rest as 1 as true

//
//public class RAT_MAZE {
//
//    /// // print  the paths
//    public static void main(String[] args) {
//
//        ///you have given the matrix, in which the elements is in the 0 & 1
//
//        int matrix[][] = {
//                {1, 1, 1, 1},
//                {1, 1, 0, 1},
//                {0, 1, 1, 1}
//        };
//
//        String s = "";
//        pathPrint(0, 0, matrix.length - 1, matrix[0].length - 1, s, matrix);
//
//
//    }
//
//
//    private static void pathPrint(int sr, int sc, int er, int ec, String s, int[][] matrix) {
//
//        if (sr < 0 || sc < 0) return;
//        if (sr > er || sc > ec) return;
//        if(matrix[sr][sc] == 0) return ;////gives the feel that at there are the permanent blocked ways
//        if(matrix[sr][sc] == -1) return ; ///  if the ways visited then
//        if (sr == er && sc == ec) {
//            System.out.println(s);////printing the string t every level if the recursion
//            return;
//        }
//
//        matrix[sr][sc] = -1; ///  marked  visited
//        pathPrint(sr + 1, sc, er, ec, s + "D", matrix);////row+1 === downways
//
//        pathPrint(sr, sc + 1, er, ec, s + "R", matrix);///col+1 === rightways
//
//        pathPrint(sr, sc - 1, er, ec, s + "L", matrix); ////  /// go left
//
//        pathPrint(sr - 1, sc, er, ec, s + "U", matrix);/// ////go up
//        /// /backtracking of the paths
//        matrix[sr][sc] = 1;
//
//    }
//
//}
//








































