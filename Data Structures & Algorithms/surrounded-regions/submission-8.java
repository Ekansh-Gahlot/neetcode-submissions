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
        for (int i = 0; i < R; i++) {
            dfs(board, i, 0);
            dfs(board, i, C - 1);
        }

        for (int j = 0; j < C; j++) {
            dfs(board, 0, j);
            dfs(board, R - 1, j);
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

    public void dfs(char[][] board, int r, int c) {
        if(board[r][c] == 'X')
        return;

        board[r][c] = '#';

        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length
                || board[nr][nc] != 'O')
                continue;
            dfs(board, nr, nc);
        }
    }
}
