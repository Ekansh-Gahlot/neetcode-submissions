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


        for(String word: wordDict){
            int n = word.length();

            if((i+n) <= s.length() && s.substring(i, n+i).equals(word)){
                if(dfs(s, wordDict, i+n))
                { 
                    map.put(i, true);
                    return true;
                }
            }
        }
        map.put(i, false);
        return false;
    } 
}
