class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {
            {1,0},
            {-1,0},
            {0,-1},
            {0,1}
        };

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0)
                q.add(new int[]{i,j});
            }
        }

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] arr = q.poll();
                int r = arr[0];
                int c = arr[1];

                for(int[] d: dir){
                    int nr = r+d[0];
                    int nc = c+d[1];

                    if(nr<0||nc<0||nr>=grid.length||nc>=grid[0].length||grid[nr][nc]!=Integer.MAX_VALUE)
                    continue;

                    grid[nr][nc] = grid[r][c] + 1;
                    q.add(new int[]{nr,nc});
                }
            }
        }

    }
}
