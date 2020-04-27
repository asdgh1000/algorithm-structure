package algorithm.leetCode.week03.No200;

/**
 * @author ltw
 * on 2020-03-04.
 */
class Solution {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int islands = 0;
        for (int y = 0; y < grid.length; ++y) { //y轴
            for (int x = 0; x < grid[0].length; ++x) { //x轴
                if (grid[y][x] == '1') {
                    ++islands;
                    dfs(grid, y, x);
                }
            }
        }
        return islands;
    }

    void dfs(char[][] grid, int r, int c) {
        int y = grid.length;
        int x = grid[0].length;

        if (r < 0 || c < 0 || r >= y || c >= x || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }


}