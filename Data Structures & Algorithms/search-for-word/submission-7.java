class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, word, visited, i, j, 0))
                return true;
            }
        }
        return false;
    }


    public boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int k){
        if(k == word.length())
        return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(k))
        return false;

        visited[i][j] = true;
        boolean res = dfs(board, word, visited, i+1, j , k+1) || dfs(board, word, visited, i-1, j , k+1) || dfs(board, word, visited, i, j+1 , k+1) || dfs(board, word, visited, i,j-1, k+1);
        visited[i][j] = false;
        return res;

    }
}
