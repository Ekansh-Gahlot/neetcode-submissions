class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROW = heights.length;
        int COL = heights[0].length;
        boolean[][] pac = new boolean[ROW][COL];
        boolean[][] atl = new boolean[ROW][COL];
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < ROW; i++){
            dfs(i,0,pac,heights);
            dfs(i,COL-1,atl,heights);
        }

        for(int j = 0 ; j < COL; j++){
            dfs(0,j,pac,heights);
            dfs(ROW-1,j,atl,heights);
        }


        for(int i = 0 ; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(pac[i][j] && atl[i][j]){
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


    public void dfs(int i, int j, boolean[][] ocean, int[][]heights){

        if(ocean[i][j])
        return;

        ocean[i][j] = true;


        for(int[] d: dir){
            int nr = i + d[0];
            int nc = j + d[1];

            if(nr < 0 || nc < 0 || nr >= heights.length || nc >= heights[0].length || heights[i][j] > heights[nr][nc])
            continue;

            dfs(nr, nc, ocean, heights);
        }

    }
}
