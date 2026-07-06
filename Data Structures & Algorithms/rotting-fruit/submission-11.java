class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1)
                fresh++;
            }
        }


      

        int[][] dir = {
            {0,1},
            {1,0},
            {-1,0},
            {0,-1}
        };

        int count = 0;

        while(fresh > 0 && !q.isEmpty()){
            int level = q.size();
            for(int i = 0; i < level; i++){
                int[] arr = q.poll();
                int r = arr[0];
                int c = arr[1];
                for(int[] d: dir){
                    int nr = r+d[0];
                    int nc = c+d[1];

                    if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] != 1)
                    continue;

                    if(grid[nr][nc] == 1){
                        fresh--;
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            count++;

        }

        return fresh == 0 ? count : -1;
        
    }
}
