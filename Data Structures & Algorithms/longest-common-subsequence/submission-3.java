class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int longestCommonSubsequence(String text1, String text2) {
        return dfs(0,0,text1, text2);
    }

    public int dfs(int i, int j, String text1, String text2){
        if(i==text1.length()||j==text2.length()){
            return 0;
        }
        String key = i+"-"+j;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int res;
        if(text1.charAt(i)==text2.charAt(j)){
          res = 1 + dfs(i+1, j+1, text1, text2);
        }else{
            res = Math.max(dfs(i+1, j, text1, text2), dfs(i,j+1, text1, text2));
        }
        map.put(key, res);
        return res;
    }
}
