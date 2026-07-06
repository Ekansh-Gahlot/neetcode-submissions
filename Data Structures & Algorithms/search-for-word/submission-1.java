class Solution {
    int ROWS;
    int COLS;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(dfs(r,c,0, word, board)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int r, int c, int i, String word, char[][] board){
        if(i == word.length())
        return true;

        if(r >= ROWS || c >= COLS || r < 0 || c < 0 || visited[r][c] || board[r][c] != word.charAt(i))
        return false;

        visited[r][c] = true;

        boolean res = dfs(r,c+1, i+1, word, board) ||  dfs(r,c-1, i+1, word, board) ||  dfs(r-1,c, i+1, word, board) ||  dfs(r+1,c, i+1, word, board);
        visited[r][c] = false;
        return res;
    }
}
