class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;

        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i = 0 ; i < r; i++){
            for(int j = 0; j < c; j++){
                if(backTrack(board, word, vis, i , j, 0))
                return true;
            }
        }
        return false;

    }
    public boolean backTrack(char[][] board, String word, boolean[][] vis, int i, int j, int k){
        if(k >= word.length())
        return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || vis[i][j] || board[i][j] != word.charAt(k))
        return false;
        vis[i][j] = true;
        boolean res = backTrack(board, word, vis, i+1, j, k+1) ||
                      backTrack(board, word, vis, i-1, j, k+1) ||
                      backTrack(board, word, vis, i, j+1, k+1) ||
                      backTrack(board, word, vis, i, j-1, k+1);
        vis[i][j] = false;
        return res;
    }
}
