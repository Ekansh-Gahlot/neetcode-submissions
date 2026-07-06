class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int count = 0;
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2)
                {
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1)
                fresh++;
            }
        }

        int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(fresh > 0 && !q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
            int cell[] = q.poll();
            int r = cell[0];
            int c = cell[1];
            for(int[] d: dir){
                int nr = r+d[0];
                int nc = c+d[1];

                if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] != 1)
                continue;

                grid[nr][nc] = 2; 
                q.add(new int[]{nr, nc});
                fresh--;
                }
            }
            count++;
        }
        return fresh == 0 ? count : -1 ;
    }
}
