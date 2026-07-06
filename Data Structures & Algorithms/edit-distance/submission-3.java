class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int minDistance(String start, String target) {
      return dfs(start, target, 0, 0);
    }


    public int dfs(String s1, String s2, int i, int j){
      if(i==s1.length()) return s2.length()-j;
      if(j==s2.length()) return s1.length()-i;
      String key = i+"-"+j;
      if(map.containsKey(key))
      return map.get(key);
      int ans;
      if(s1.charAt(i) == s2.charAt(j)){
        ans = dfs(s1,s2,i+1,j+1);
      }
      else{
        int insert = dfs(s1,s2,i,j+1);
        int delete = dfs(s1,s2,i+1,j);
        int replace = dfs(s1,s2,i+1,j+1);

        ans = 1 + Math.min(insert,Math.min(delete,replace));

      }
      map.put(key,ans);
      return ans;
    }
}
