class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int[][] dir = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
        };
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2)
                q.add(new int[]{i,j});
                if(grid[i][j] == 1)
                fresh++;
            }
        }
        int min = 0;
        while(!q.isEmpty() && fresh != 0){
            int level = q.size();
            for(int i = 0 ; i < level; i++){
                int[] arr = q.poll();
                int r = arr[0];
                int c = arr[1];
                for(int[] d: dir){
                    int nr = r+d[0];
                    int nc = c+d[1];
                    if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc]!=1)
                    continue;
                    grid[nr][nc] = 2;
                    q.add(new int[]{nr,nc});
                    fresh--; 
                }
            }
            min++;
        }
        return fresh == 0 ? min : -1;
    }
}
