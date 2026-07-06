class Solution {
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0) //gate
                q.add(new int[]{i,j});
            }
        }
    

    if(q.size() == 0)
    return;

    while(!q.isEmpty()){
        int[] arr = q.poll();
        int r = arr[0];
        int c = arr[1];

        for(int[] d: directions){
            int nr = r+d[0];
            int nc = c+d[1];

            if(nr >= grid.length || nc >= grid[0].length || nr < 0 || nc < 0 || grid[nr][nc] != Integer.MAX_VALUE)
            continue;

            q.add(new int[]{nr,nc});
            grid[nr][nc] = grid[r][c]+1;

        }
    }
    }
}
