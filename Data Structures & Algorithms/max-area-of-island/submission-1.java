class Solution {
    int[][] dir = {
        {1,0},{0,1},{-1,0},{0,-1}
    };
    public int maxAreaOfIsland(int[][] grid) {
        int size = 0;

        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                {
                    int result = dfs(grid, i, j);
                    size = Math.max(size, result);
                }
            }
        }
        return size;
    }

    public int dfs(int[][] grid, int r, int c){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length|| grid[r][c] == 0)
        return 0;

        grid[r][c] = 0;
        int size = 1;

        for(int[] d: dir){
            int nr = r+d[0];
            int nc = c+d[1];
            size += dfs(grid, nr, nc);
        }
        return size;
    }
}
