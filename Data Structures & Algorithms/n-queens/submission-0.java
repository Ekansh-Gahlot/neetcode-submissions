class Solution {
    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row: board){
            Arrays.fill(row,'.');
        }
        backTrack(0, board, n);
        return res;
    }

    public void backTrack(int r, char[][] board, int n){
        if(r == n){
            List<String> copy = new ArrayList<>();
            for(char[] row: board){
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for(int c = 0; c < n; c++){
            if(col.contains(c) || posDiag.contains(r+c) || negDiag.contains(r-c))
            continue;

            col.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);
            board[r][c] = 'Q';

            backTrack(r+1, board, n);

            col.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
            board[r][c] = '.';
        }
    }
}
