class Solution {
    int[][] directions = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int size = 0;
        for(int r = 0 ; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1){
                    int result = dfs(grid, r, c);
                    size = Math.max(size, result);
                }
            }
        }
        return size;
    }

    public int dfs(int[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0)
        return 0;

        grid[r][c] = 0;
        int size = 1;

        for(int[] dir: directions){
            int nr = r+dir[0];
            int nc = c+dir[1];
            size += dfs(grid, nr, nc);
        }
        return size;
    }
}
