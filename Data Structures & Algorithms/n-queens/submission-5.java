class Solution {
    List<List<String>> list = new ArrayList<>();
    HashSet<Integer> posDiag = new HashSet<>();
    HashSet<Integer> negDiag = new HashSet<>();
    HashSet<Integer> col = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] c: board){
            Arrays.fill(c, '.');
        }

        backTrack(board, n, 0);
        return list;
    }

    public void backTrack(char[][] board, int n, int r){
        if(r >= board.length){
            List<String> temp = new ArrayList<>();
            for(char[] c: board){
                temp.add(new String(c));
            }
            list.add(temp);
            return;
        }
        for(int c = 0 ; c < board[0].length; c++){
            if(board[r][c] != 'Q' && !posDiag.contains(r+c) && !negDiag.contains(r-c) && !col.contains(c)){
                board[r][c] = 'Q';
                posDiag.add(r+c);
                negDiag.add(r-c);
                col.add(c);
                backTrack(board, n, r+1);
                board[r][c] = '.';
                posDiag.remove(r+c);
                negDiag.remove(r-c);
                col.remove(c);
            }
        }
    }
}
