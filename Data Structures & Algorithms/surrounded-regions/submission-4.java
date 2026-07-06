class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        for(int j = 0; j < COLS; j++){
            dfs(board, 0, j);
            dfs(board, ROWS-1, j);
        }

          for(int i = 0; i < ROWS; i++){
            dfs(board, i, 0);
            dfs(board,i, COLS-1);
        }

        for(int i = 0 ; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                   if(board[i][j] == 'O')
                   board[i][j] = 'X';
                if(board[i][j] == '3')
                board[i][j] = 'O';
             
            }
        }
    }
    int dir[][] = {
        {1,0},
        {0,1},
        {0,-1},
        {-1,0}
    };
    public void dfs(char[][] board, int i, int j){
        if(board[i][j] != 'O') return;
        board[i][j] = '3';

        for(int[] d: dir){
            int nr = i + d[0];
            int nc = j + d[1];

            if(nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length || board[nr][nc] != 'O')
            continue;

            dfs(board, nr, nc);
        }
    }
}
