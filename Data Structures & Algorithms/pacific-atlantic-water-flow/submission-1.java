class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pac = new boolean[row][col];
        boolean[][] atl = new boolean[row][col];
         List<List<Integer>> list = new ArrayList<>();

        for(int r = 0; r < row; r++){
            dfs(heights, r, 0, pac);
            dfs(heights, r, col-1, atl);
        }


        for(int c = 0; c < col; c++){
            dfs(heights, 0, c, pac);
            dfs(heights, row-1, c, atl);
        }

        for(int i = 0; i < row; i++){
            for(int j = 0 ; j < col; j++){
                if(pac[i][j] && atl[i][j])
                list.add(Arrays.asList(i,j));
            }
        }
        return list;
    }
    int[][] dir = {
        {0,1},{1,0},{-1,0},{0,-1},
    };
    public void dfs(int[][] heights, int r, int c, boolean[][] ocean){

        ocean[r][c] = true;

        for(int[] d: dir){
            int nr = r+d[0];
            int nc = c+d[1];

            if(nr<0||nr>=heights.length||nc<0||nc>=heights[0].length||ocean[nr][nc]||heights[nr][nc] < heights[r][c])
            continue;
            dfs(heights, nr, nc, ocean);
        }
    }
}
