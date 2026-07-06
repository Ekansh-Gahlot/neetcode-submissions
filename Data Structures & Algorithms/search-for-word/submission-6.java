class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(0, board, word, i, j))
                return true;
            }
        }
        return false;
    }

    public boolean dfs(int k, char[][] board, String word, int i, int j){
        if(k >= word.length())
        return true;

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(k))
        return false;

        visited[i][j] = true;
        boolean res = dfs(k+1, board, word, i+1, j) || dfs(k+1, board, word, i-1, j) || dfs(k+1, board, word, i, j+1) || dfs(k+1, board, word, i, j-1);
        visited[i][j] = false;
        return res;
    }
}
