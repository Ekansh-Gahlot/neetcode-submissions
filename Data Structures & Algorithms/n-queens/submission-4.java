class Solution {
    HashSet<Integer> negDiag = new HashSet<>();
    HashSet<Integer> posDiag = new HashSet<>();
    HashSet<Integer> col = new HashSet<>();
    List<List<String>> list = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(char[] b: board){
            Arrays.fill(b, '.');
        }

        dfs(board, 0, n);
        
        return list;
    }

    public void dfs(char[][] board, int r, int n){
        if(r == n){ 
           List<String> temp = new ArrayList<>();
            for(char[] b: board){
                 temp.add(new String(b));
            }
            list.add(new ArrayList<>(temp));
            return;
            
        }

        for(int c = 0; c < n; c ++){
            if(!negDiag.contains(r-c) && !posDiag.contains(r+c) && !col.contains(c)){
                negDiag.add(r-c);
                posDiag.add(r+c);
                col.add(c);

                board[r][c] = 'Q';
                dfs(board, r+1, n);
                board[r][c] = '.';
                negDiag.remove(r-c);
                posDiag.remove(r+c);
                col.remove(c);
            }
        }
    }
}
