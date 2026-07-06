class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        return dfs(s1,s2,s3,0,0);
    }

    public boolean dfs(String s1, String s2, String s3, int i, int j){
        if(i == s1.length() && j == s2.length())
        return true;

        String key = i+"-"+j;
        if(map.containsKey(key))
        return map.get(key);


        int k = i+j;
        if(i<s1.length() && s1.charAt(i) == s3.charAt(k)){
            if(dfs(s1,s2,s3,i+1,j))
            {
                map.put(key, true);
                return true;
            }
        }
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            if(dfs(s1,s2,s3,i,j+1)){
                map.put(key, true);
                return true;
            }
        }
        map.put(key,false);
        return false;
    }
}
