class Solution {
    private static final int[][] directions = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int numOfIslands = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == '1')
                {
                    dfs(r,c,grid);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    public void dfs(int r, int c, char[][] grid){
        if(r >= grid.length || r < 0 || c < 0 || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';

        for(int dir[]: directions){
            int nr = dir[0];
            int nc = dir[1];

            dfs(r+nr, c+nc, grid);
        }
    }
}
