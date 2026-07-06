class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        int row = heights.length; 
        int col = heights[0].length;

        boolean[][] atl = new boolean[row][col];
        boolean[][] pac = new boolean[row][col];

        for(int i = 0; i < row; i++){
            dfs(heights, i, 0, pac);
            dfs(heights, i, col-1, atl);
        }
        for(int i = 0; i < col; i++){
            dfs(heights, 0, i, pac);
            dfs(heights, row-1, i, atl);
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(atl[i][j] && pac[i][j]){
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        return list;
    }

    int[][] dir = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public void dfs(int[][] heights, int r, int c, boolean[][] ocean){
        if(ocean[r][c])
        return;

        ocean[r][c] = true;

        for(int[] d: dir){
            int nr = r+d[0];
            int nc = c+d[1];

            if(nr < 0 || nc < 0 || nr >= heights.length || nc >= heights[0].length || heights[nr][nc] < heights[r][c])
            continue;
            dfs(heights, nr, nc, ocean);
        }
    }
}
