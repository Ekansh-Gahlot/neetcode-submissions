class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int minDistance(String word1, String word2) {
        return dfs(0,0,word1, word2);
    }

    public int dfs(int i, int j, String word1, String word2){
        if(i==word1.length()) return word2.length()-j;
        if(j==word2.length()) return word1.length()-i;
        String key = i + "-" + j;
        if(map.containsKey(key))
        return map.get(key);
        int ans;
        if(word1.charAt(i) == word2.charAt(j))
        ans = dfs(i+1, j+1, word1, word2);
        else{
            int insert = dfs(i,j+1,word1, word2);
            int delete = dfs(i+1,j, word1, word2);
            int replace = dfs(i+1, j+1, word1, word2);

            ans = 1 + Math.min(insert, Math.min(delete, replace));
        }
        map.put(key, ans);
        return ans;
    }
}
