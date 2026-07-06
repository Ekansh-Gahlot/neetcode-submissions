class Solution {
    HashMap<Integer, Integer> map;
    public int numDecodings(String s) {
        map = new HashMap<>();
       int result = dfs(s, 0);
       return result;
    }

    public int dfs(String s, int i){
        if(i == s.length()){
           return 1;
        }
        if(s.charAt(i) == '0')
        return 0;

        if(map.containsKey(i))
        return map.get(i);

        int res = dfs(s, i+1);

        if(((i+1) < s.length()) && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))){
            res += dfs(s,i+2);
        }
        map.put(i, res);
        return res;
    }
}
