class Solution {
    int [][] dir = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for(int c = 0; c < COLS; c++){
            dfs(0, c, heights, pac);
            dfs(ROWS-1, c, heights, atl);
        }

        for(int r = 0; r < ROWS; r++){
            dfs(r, 0, heights, pac);
            dfs(r, COLS-1, heights, atl);
        }

        List<List<Integer>> list = new ArrayList<>();

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(pac[r][c] && atl[r][c]){
                    list.add(Arrays.asList(r,c));
                }
            }
        }
        return list;
    }

    public void dfs(int r, int c, int[][] heights, boolean[][] ocean){
        ocean[r][c] = true;

        for(int d[]: dir){
            int nr = r+d[0];
            int nc = c+d[1];

            if(nr < 0 || nr >= heights.length || nc < 0 || nc >= heights[0].length || heights[nr][nc] < heights[r][c] || ocean[nr][nc])
            continue;

            dfs(nr, nc, heights, ocean);
        }

    }
}
