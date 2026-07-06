class Solution {
    public boolean exist(char[][] board, String word) {
        
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, word, vis, i, j, 0))
                return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, boolean[][] vis, int i, int j, int k){
        if(k == word.length())
        return true;

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || vis[i][j] || word.charAt(k) != board[i][j])
        return false;

        vis[i][j] = true;

        int dir[][] = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
        };

        for(int d[]: dir){
            int nr = i+d[0];
            int nc = j+d[1];

            if(dfs(board, word, vis, nr, nc, k+1))
            return true;
        }
        vis[i][j] = false;
        return false;

        
    }

}
