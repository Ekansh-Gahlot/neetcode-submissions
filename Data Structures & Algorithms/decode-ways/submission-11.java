class Solution {
    public int numDecodings(String s) {
        int res = dfs(s, 0);
        return res;
    }

    public int dfs(String s, int i){
        if(i >= s.length()){
            return 1;
        }

        if(s.charAt(i) == '0')
        return 0;

        int res = dfs(s, i+1);
        if (i+1 < s.length() && 
        (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))) 
        res += dfs(s, i+2);


        return res;
        
    }
}
