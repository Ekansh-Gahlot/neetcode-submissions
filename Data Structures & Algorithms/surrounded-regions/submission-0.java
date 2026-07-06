class Solution {
    int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};

    public void solve(char[][] board) {
        int row = board.length;
        if(row == 0) return;
        int col = board[0].length;

        // Step 1: mark border-connected 'O's
        for(int r = 0; r < row; r++) {
            dfs(board, r, 0);
            dfs(board, r, col-1);
        }
        for(int c = 0; c < col; c++) {
            dfs(board, 0, c);
            dfs(board, row-1, c);
        }

        // Step 2: flip surrounded 'O' -> 'X', restore safe '3' -> 'O'
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '3') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if(board[r][c] != 'O') return;

        board[r][c] = '3'; // mark safe

        for(int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length || board[nr][nc] != 'O')
                continue;

            dfs(board, nr, nc);
        }
    }
}
