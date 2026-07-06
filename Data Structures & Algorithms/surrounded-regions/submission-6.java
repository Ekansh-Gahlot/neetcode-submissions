class Solution {
    int[][] dir = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1},
    };
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        for(int i = 0; i < ROWS; i++){
            dfs(board,i,0);
            dfs(board,i,COLS-1);
        }


        for(int j = 0; j < COLS; j++){
            dfs(board,0,j);
            dfs(board,ROWS-1,j);
        }

        for(int i = 0 ; i < ROWS; i++){
            for(int j = 0 ; j < COLS; j++){
                if(board[i][j] == '3')
                board[i][j] = 'O';
                else if(board[i][j] == 'O')
                board[i][j] = 'X';
            }
        }
    }

    public void dfs(char[][] board, int r, int c){
        if(board[r][c] != 'O') return;

        board[r][c] = '3';

        for(int d[]: dir){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr < 0 || nc < 0 ||nr >= board.length || nc >=board[0].length)
            continue;
            dfs(board, nr, nc);
        }
    }
}
