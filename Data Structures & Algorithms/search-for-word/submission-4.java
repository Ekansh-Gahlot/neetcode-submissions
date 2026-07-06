class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];

        for(int i = 0 ; i < rows; i++){
            for(int j = 0 ; j < cols; j++){
                if(dfs(board, i, j, word, 0))
                return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int k){
        if(k == word.length()){
            return true;
        }

        if( i >= board.length || j >= board[0].length || i < 0 || j < 0 || visited[i][j] || word.charAt(k)!=board[i][j])
        return false;

        visited[i][j] = true;

        boolean result = dfs(board, i+1 , j , word, k+1) || dfs(board, i , j+1, word, k+1) || dfs(board, i-1 , j , word, k+1) || dfs(board, i , j-1 , word, k+1);
        visited[i][j] = false;
        return result;
    }
}
