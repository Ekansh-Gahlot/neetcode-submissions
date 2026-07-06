class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();

        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for(int r = 0; r < ROWS; r++){
            dfs(heights, r, 0, pac);
            dfs(heights, r, COLS-1, atl);
        }

        for(int c = 0; c < COLS; c++){
            dfs(heights, 0, c, pac);
            dfs(heights, ROWS-1, c, atl);
        }

        for(int i = 0 ; i < ROWS; i++){
            for(int j = 0 ; j < COLS; j++){
                if(pac[i][j] && atl[i][j])
                ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }
    int[][] dir = {
        {1,0},{0,1},{-1,0},{0,-1}
    };

    public void dfs(int[][] heights, int r, int c, boolean[][] ocean){
        ocean[r][c] = true;

        for(int[] d: dir){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr < 0 || nc < 0 || nr >= heights.length || nc >= heights[0].length || ocean[nr][nc] || heights[r][c] > heights[nr][nc])
            continue;

            dfs(heights, nr, nc, ocean);
        }
    }
}
