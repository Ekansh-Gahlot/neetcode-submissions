class Solution {
    HashMap<Integer, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }

    public boolean dfs(String s, List<String> wordDict, int i){
        if(i >= s.length())
        return true;
        if(map.containsKey(i))
        return map.get(i);

        for(String w: wordDict){
            int len = w.length();
            if((i+len) <= s.length() && w.equals(s.substring(i,i+len))){
                if(dfs(s, wordDict, i+len)){
                    map.put(i, true);
                    return true;
                }
            }
        }
        map.put(i, false);
        return false;
    }
}

