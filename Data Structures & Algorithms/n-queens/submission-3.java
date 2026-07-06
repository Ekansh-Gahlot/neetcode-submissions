class Solution {
    HashSet<Integer> negDiag = new HashSet<>();
    HashSet<Integer> posDiag = new HashSet<>();
    HashSet<Integer> col = new HashSet<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(char[] b: board){
            Arrays.fill(b, '.');
        }

        dfs(n, 0, board);
        return res;
    }

    public void dfs(int n, int r, char[][] board){
        if(r == n){
            List<String> temp = new ArrayList<>();
            for(char[] b: board){
                temp.add(new String(b));
            }
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int c = 0; c < n ; c++){
            if(!negDiag.contains(r-c) && board[r][c] != 'Q' && !posDiag.contains(r+c) && !col.contains(c)){
                negDiag.add(r-c);
                posDiag.add(r+c);
                col.add(c);
                board[r][c] = 'Q';
                dfs(n, r+1, board);
                board[r][c] = '.';
                negDiag.remove(r-c);
                posDiag.remove(r+c);
                col.remove(c);
                

            }
        }
        
    }
}
