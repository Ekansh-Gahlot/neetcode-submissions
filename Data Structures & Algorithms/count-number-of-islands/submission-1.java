class Solution {
    int result = 0;
    int[][] directions = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public int numIslands(char[][] grid) {
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1')
                {
                    dfs(i, j, grid);
                    result++;
                }
                
            }
        }
        return result;
        
    }

    public void dfs(int i, int j, char[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
        return;
        grid[i][j] = '0';
        for(int[] dir: directions){
            int nr = i+dir[0];
            int nc = j+dir[1];
            dfs(nr, nc, grid);
        }
    }
}
