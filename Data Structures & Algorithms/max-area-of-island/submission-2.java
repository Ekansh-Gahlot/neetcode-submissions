class Solution {
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int size = 0;
        
        

        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
               if(grid[i][j] == 1){
               int temp = dfs(grid, i, j);
               size = Math.max(size, temp);
               }
            }
        }
        return size;
    }

    public int dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
        return 0;

        grid[i][j] = 0;
        int size = 1;

        for(int[] d: dir){
            int nr = d[0]+i;
            int nc = d[1]+j;
            size += dfs(grid, nr, nc);
        }
        return size;

    }

    
}
