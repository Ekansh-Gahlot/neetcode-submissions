class Solution {
    public void solve(char[][] board) {
        

        int ROWS = board.length;
        int COLS = board[0].length;

        for(int r = 0; r < ROWS; r++){
            dfs(r, 0, board);
            dfs(r, COLS-1, board);
        }


        for(int c = 0; c < COLS; c++){
            dfs(0, c, board);
            dfs(ROWS-1, c, board);
        }

        for(int i = 0; i < ROWS; i++){
            for(int j = 0 ; j < COLS; j++){
                if(board[i][j] == 'O')
                board[i][j] = 'X';
                if(board[i][j] == '3')
                board[i][j] = 'O';
            }
        }

    }
    int[][] dir = {
        {0,1},{1,0},{-1,0},{0,-1}
    };
    public void dfs(int r, int c, char[][] board){
        if(board[r][c] != 'O') return;
        board[r][c] = '3';

        for(int[] d: dir){
            int nr = r+d[0];
            int nc = c+d[1];

            if(nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length || board[nr][nc] != 'O') 
            continue;

            dfs(nr, nc, board);
        }
    }
}
