class Solution {
    int[][] dir = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        List<List<Integer>> list = new ArrayList<>();
        boolean[][] pac = new boolean[r][c];
        boolean[][] atl = new boolean[r][c];

        for(int i = 0 ; i < r; i++){
            dfs(heights, pac, i, 0);
            dfs(heights, atl, i, c-1);
        }


        for(int j = 0 ; j < c; j++){
            dfs(heights, pac, 0, j);
            dfs(heights, atl, r-1, j);
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(atl[i][j] && pac[i][j])
                {
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        return list;
    }


    public void dfs(int[][] heights, boolean[][] ocean, int r, int c){
        ocean[r][c] = true;

        for(int d[]: dir){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr < 0 || nc < 0 || nr >= heights.length || nc >= heights[0].length || heights[nr][nc] < heights[r][c] || ocean[nr][nc])
            continue;

            dfs(heights, ocean, nr, nc);
        }


    }
}
