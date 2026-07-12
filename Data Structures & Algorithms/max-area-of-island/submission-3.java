class Solution {
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int ans = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = 0;
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    maxArea = Math.max(ans, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        ans++;

        for (int d[] : dir) {
            int nr = i + d[0];
            int nc = j + d[1];

            if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length
                || grid[nr][nc] != 1)
                continue;
                dfs(grid, nr, nc);
        }
        return ans;
    }
}
