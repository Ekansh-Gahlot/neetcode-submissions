class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return dfs(0,0,s1,s2,s3);
    }
    public boolean dfs(int i, int j, String s1, String s2, String s3){
        if(i==s1.length() && j==s2.length()){
            return true;
        }

        String key = i+"-"+j;
        if(map.containsKey(key))
        return map.get(key);
        int k = i+j;

        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            if(dfs(i+1,j,s1,s2,s3)){
                map.put(key, true);
                return true;
            }
        }if( j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            if(dfs(i,j+1, s1,s2,s3))
            {
                map.put(key,true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
}
