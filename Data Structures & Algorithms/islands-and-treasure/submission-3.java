class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0)
                q.add(new int[]{i,j});
            }
        }

        int[][] dir = {{1,0},{0,1},{0,-1},{-1,0}};

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for(int[] d: dir){
                int nr = row+d[0];
                int nc = col+d[1];

                if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc]!=Integer.MAX_VALUE){
                    continue;
                }
                q.add(new int[]{nr, nc});
                grid[nr][nc] = 1 + grid[row][col];
            }
        }
    }
}
