class Solution {
    public int lengthOfLongestSubstring(String s) {
      boolean vis[] = new boolean[256];
      int maxLen = 0;
      int left = 0 ;

      for(int right = 0; right < s.length(); right++){

        while(vis[s.charAt(right)])
        {
            vis[s.charAt(left)] = false;
            left++;
        }
        vis[s.charAt(right)] = true;
        maxLen = Math.max(maxLen, (right-left+1));
      }
      return maxLen;  
    }
}
