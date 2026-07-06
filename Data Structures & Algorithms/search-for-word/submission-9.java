class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];

        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){ 
                if(dfs(i, j, word, board, 0, vis))
                return true;
            }
        }
        return false;
    }
    int[][] dir = {
        {1,0},{0,1},{-1,0},{0,-1}
    };
    public boolean dfs(int i, int j, String word, char[][] board, int k, boolean[][] vis){
        if(k >= word.length())
        return true;

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(k) || vis[i][j])
        return false;


        vis[i][j] = true;

        for(int[] d: dir){
            int nr = i+d[0];
            int nc = j+d[1];

            if((dfs(nr, nc, word, board, k+1, vis)))
            return true;
        }
        vis[i][j] = false;
        return false;

    }
}
