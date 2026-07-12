class Solution {
    int[][] dir = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };
    public void solve(char[][] board) {
        int R = board.length;
        int C = board[0].length;
        boolean[][] vis = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            dfs(board, i, 0, new boolean[R][C] );
            dfs(board, i, C - 1, new boolean[R][C]);
        }

        for (int j = 0; j < C; j++) {
            dfs(board, 0, j, new boolean[R][C]);
            dfs(board, R - 1, j, new boolean[R][C]);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int r, int c, boolean[][] vis) {
        if(board[r][c] == 'X')
        return;
        
        if (board[r][c] == 'O')
            board[r][c] = '#';

        vis[r][c] = true;

        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length
                || board[nr][nc] != 'O' || vis[nr][nc])
                continue;
            dfs(board, nr, nc, vis);
        }
    }
}
