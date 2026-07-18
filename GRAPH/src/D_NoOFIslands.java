import java.util.LinkedList;
import java.util.Queue;

public class D_NoOFIslands {


    class Pair {

        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfst(i, j, visited, grid);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfst(int i, int j, boolean[][] visited, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(i, j));

        while (!q.isEmpty()) {
            Pair front = q.poll();

            int row = front.row, col = front.col;
            //// for the top   check
            if (row > 0) {
                if (grid[row - 1][col] == '1' && !visited[row - 1][col]) {

                    q.add(new Pair(row - 1, col));
                    visited[row - 1][col] = true;
                }
            }

            /// for the right
            if (col < n) {
                if (grid[row][col + 1] == '1' && !visited[row][col + 1]) {

                    q.add(new Pair(row, col + 1));
                    visited[row][col + 1] = true;
                }
            }

            // for the left check
            if (col > 0) {
                if (grid[row][col - 1] == '1' && !visited[row][col - 1]) {

                    q.add(new Pair(row, col - 1));
                    visited[row][col - 1] = true;
                }
            }
            //// for the down
            if (row < m) {
                if (grid[row + 1][col] == '1' && !visited[row + 1][col]) {

                    q.add(new Pair(row + 1, col));
                    visited[row + 1][col] = true;
                }
            }
        }
    }




    //// fromn here the code of the dfs
    public int numIslandsdfs(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, visited, grid);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, boolean[][] visited, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int row = i;
        int col = j;

        // Top
        if (row > 0 && grid[row - 1][col] == '1' && !visited[row - 1][col]) {
            visited[row - 1][col] = true;
            dfs(row - 1, col, visited, grid);
        }

        // Right
        if (col < n - 1 && grid[row][col + 1] == '1' && !visited[row][col + 1]) {
            visited[row][col + 1] = true;
            dfs(row, col + 1, visited, grid);

        }

        // Left
        if (col > 0 && grid[row][col - 1] == '1' && !visited[row][col - 1]) {
            visited[row][col - 1] = true;
            dfs(row, col - 1, visited, grid);
        }

        // Down
        if (row < m - 1 && grid[row + 1][col] == '1' && !visited[row + 1][col]) {
            visited[row + 1][col] = true;
            dfs(row + 1, col, visited, grid);
        }
    }



}
