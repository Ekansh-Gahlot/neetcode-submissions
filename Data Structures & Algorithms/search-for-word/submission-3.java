class Solution {
    int ROWS;
    int COLS;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(wordCheck(board, word, i , j, 0))
                return true;
            }
        }
        return false;
    }

    public boolean wordCheck(char[][] board,String word, int i, int j, int k){

        if(k == word.length())
        return true;


        if(i >= ROWS || i < 0 || j >= COLS || j < 0 || (word.charAt(k) != board[i][j]) || visited[i][j])
        return false;

        visited[i][j] = true;

        boolean res = wordCheck(board, word, i+1, j, k+1) || wordCheck(board, word, i-1, j, k+1) || wordCheck(board, word, i, j+1, k+1) || wordCheck(board, word, i, j-1, k+1);
        visited[i][j] = false;
        return res;


        
    }
}
