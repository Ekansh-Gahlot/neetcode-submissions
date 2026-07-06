class Solution {
    public List<String> generateParenthesis(int n) {
        //Solve by backtracking which has - 
        //1) Base conditon
        //2) Some decision making to do
        List<String> list = new ArrayList<>();
        backtrack(list, n, "", 0, 0);
        return list;
    }

    public void backtrack(List<String> list, int max, String curr_str, int open, int close){
        if(curr_str.length() == max*2)
        list.add(curr_str);

        if(open < max)
        backtrack(list, max, curr_str + "(", open+1, close);
        if(close < open)
        backtrack(list, max, curr_str + ")", open, close+1);
    }
}
