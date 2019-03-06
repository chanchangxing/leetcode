import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenchangxing on 2019/3/5.
 */
public class NumIslands {
    private static int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private static void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return;
        }

        if (grid[i][j] == '0' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j - 1);
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i, j + 1);

    }

    public static void main(String[] args) {
        char[][] chars = new char[2][5];
        chars[0] = new char[]{'1', '0', '1', '0', '0'};
        chars[1] = new char[]{'0', '1', '0', '0', '1'};
//        chars[2] = new char[]{'1', '1', '1', '0', '1'};
//        chars[3] = new char[]{'0', '0', '0', '0', '0'};


        System.out.println(numIslands(chars));
    }
}
