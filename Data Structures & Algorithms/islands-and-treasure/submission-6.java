class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < ROWS; i++){
            for(int j = 0 ; j < COLS; j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j});
                }
            }
        }

        int[][] dir = {
            {0,1},{1,0},{-1,0},{0,-1}
        };
        int dis = 0;
        while(!q.isEmpty()){
            int level = q.size();
            for(int i = 0 ; i < level; i++){
                int[] arr = q.poll();
                int r = arr[0];
                int c = arr[1];

                for(int[] d: dir){
                    int nr = r+d[0];
                    int nc = c+d[1];
                    if(nr < 0 || nc < 0 || nr >= ROWS || nc >= COLS || grid[nr][nc]!=Integer.MAX_VALUE)
                    continue;

                    grid[nr][nc] = grid[r][c]+1;
                    q.add(new int[]{nr, nc});

                }
            }
            dis++;
        }
    }
}
