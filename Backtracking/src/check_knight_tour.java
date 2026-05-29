public class check_knight_tour {

    public static void main(String[] args) {

        int grid[][] = {
                {0,11,16,5,20},
                {17,4,19,10,15},
                {12,1,9,21,6},
                {3,18,23,14,9},
                {24,13,2,7,22}
        };

        System.out.println(checkKnight(grid));

    }

    public static boolean helper(int[][] grid, int row, int col, int num) {

        int n = grid.length;

        // base case
        if (grid[row][col] == n * n - 1) return true;


        ////// 2 up 1 right
        int i = row - 2;
        int j = col + 1;
        if ( i >= 0 && j < n && grid[i][j] == num + 1 )
            return helper(grid, i, j, num + 1);


        ////// 2 up 1 left
        i = row - 2;
        j = col - 1;
        if (i >= 0 && j >= 0 && grid[i][j] == num + 1)
            return helper(grid, i, j, num + 1);


        ////// 2 down 1 right
        i = row + 2;
        j = col + 1;
        if (i < n && j < n && grid[i][j] == num + 1)
            return helper(grid, i, j, num + 1);


        ////// 2 down 1 left
        i = row + 2;
        j = col - 1;
        if (i < n && j >= 0 && grid[i][j] == num + 1)
            return helper(grid, i, j, num + 1);


        ////// 1 up 2 right
        i = row - 1;
        j = col + 2;
        if (i >= 0 && j < n && grid[i][j] == num + 1)
            return helper(grid, i, j, num + 1);


        ////// 1 down 2 right
        i = row + 1;
        j = col + 2;
        if (i < n && j < n && grid[i][j] == num + 1)
            return helper(grid, i, j, num + 1);


        ////// 1 down 2 left
        i = row + 1;
        j = col - 2;
        if (i < n && j >= 0 && grid[i][j] == num + 1)
            return helper(grid, i, j, num + 1);


        ////// 1 up 2 left
        i = row - 1;
        j = col - 2;
        if (i >= 0 && j >= 0 && grid[i][j] == num + 1)
            return helper(grid, i, j, num + 1);


        return false;

    }

    private static boolean checkKnight(int[][] grid) {

        if (grid[0][0] != 0) return false; //// knight must start at (0,0)
        return helper(grid, 0, 0, 0);

    }
}
