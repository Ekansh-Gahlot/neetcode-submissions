class Solution {
    HashMap<Integer, Boolean> dp = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        
        return dfs(s, wordDict, 0);
    }

    public boolean dfs(String s, List<String> wordDict, int i){
        if(i == s.length())
        return true;

        if(dp.containsKey(i))
        return dp.get(i);

        for(String word: wordDict){
            int n = word.length();
            if((i+n) <= s.length() && s.substring(i, n+i).equals(word)){
                if(dfs(s, wordDict, i+n)){
                    dp.put(i, true);
                    return true;
                }
            }
        }
        dp.put(i, false);
        return false;
    }
}
