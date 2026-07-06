class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        boolean[][] pac = new boolean[heights.length][heights[0].length];
        boolean[][] atl = new boolean[heights.length][heights[0].length];
        // boolean[][] vis = new boolean[heights.length][heights[0].length];
        List<List<Integer>> list = new ArrayList<>();
        int ROW = heights.length;
        int COL = heights[0].length;

        //Row fixed
        for(int j = 0 ; j < heights[0].length; j++){
            dfs(pac, 0, j, heights);
            dfs(atl, ROW-1, j, heights);
        }

        //Column fixed
        for(int i = 0 ; i < heights.length; i++){
            dfs(pac, i, 0, heights);
            dfs(atl, i, COL-1, heights);
        }
 
        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(pac[i][j] && atl[i][j]){
                   list.add(Arrays.asList(i,j));
                }
            }
        }
        return list;
    }
    int dir[][] = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public void dfs(boolean[][] ocean, int i, int j, int[][] heights){
        if(ocean[i][j])
        return;
        ocean[i][j] = true;

        for(int[] d: dir){
            int nr = d[0]+i;
            int nc = d[1]+j;

            if(nr < 0 || nc < 0 || nr >= heights.length || nc >= heights[0].length || heights[i][j] > heights[nr][nc])
            continue;

            dfs(ocean, nr, nc, heights);
            
        }

    }
}
