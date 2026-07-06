class Solution {
    int[][] dir = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    public int numIslands(char[][] grid) {
        int num = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }
    public void dfs(char[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0')
        return;

        grid[r][c] = '0';

        for(int[] d: dir){
            int nr = r+d[0];
            int nc = c+d[1];
            dfs(grid, nr, nc);
        }
    }
}
