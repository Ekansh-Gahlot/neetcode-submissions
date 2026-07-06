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
        grid[r][c] = '0';

        for(int[] d: dir){
            int nr = r+d[0];
            int nc = c+d[1];
            if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] == '0')
            continue;
            dfs(grid, nr, nc);
        }
    }
}
