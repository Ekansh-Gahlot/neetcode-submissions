class Solution {

    int[][] dir = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        for(int i = 0 ; i < COLS; i++){
            dfs(0,i,board);
            dfs(ROWS-1,i, board);
        }


        for(int j = 0 ; j < ROWS; j++){
            dfs(j,0,board);
            dfs(j,COLS-1, board);
        }


        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(board[i][j] == '3'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }


    public void dfs(int i, int j, char[][] board){
        if(board[i][j] != 'O') return;
        board[i][j] = '3';

        for(int d[]: dir){
            int nr = i+d[0];
            int nc = j+d[1];

            if(nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length)
            continue;
            dfs(nr, nc, board);
        }


    }
}
