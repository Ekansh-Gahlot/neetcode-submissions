class Solution {
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    Set<Integer> col = new HashSet<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(char[] row: board){
            Arrays.fill(row,'.');
        }
        dfs(n, 0, board);
        return res;
    }

    public void dfs(int n, int r, char[][] board){
        if(r == n){
            // do something
            List<String> temp = new ArrayList<>();
            for(char[] b: board){
                temp.add(new String(b));
            }
            res.add(temp);
            return;
        }

        for(int c = 0; c < n; c++){
            if(!posDiag.contains(r+c) && !negDiag.contains(r-c) && !col.contains(c)){
            posDiag.add(r+c);
            negDiag.add(r-c);
            col.add(c);
            board[r][c] = 'Q';
            dfs(n, r+1, board);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
            col.remove(c);
            board[r][c] = '.';
            }

        }

    }
}
