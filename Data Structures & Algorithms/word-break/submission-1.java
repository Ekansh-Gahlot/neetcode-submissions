class Solution {
    HashMap<Integer, Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        return dfs(s, wordDict, 0);
    }

    public boolean dfs(String s, List<String> wordDict, int i){
        if(i == s.length())
        return true;

        if(map.containsKey(i))
        return map.get(i);


        for(String w: wordDict){
            if(i+w.length() <= s.length() && s.substring(i, i+w.length()).equals(w)){
                if(dfs(s, wordDict, i+w.length()))
                return true;
            }
        }
        map.put(i,false);
        return false;
    }
}
