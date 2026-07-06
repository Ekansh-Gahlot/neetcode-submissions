class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean vis[] = new boolean[256];
        int left = 0;
        // int right = 0;
        int maxLen = 0;

        for(int right = 0 ; right < s.length(); right++)
        {
            while(vis[s.charAt(right)]){
                vis[s.charAt(left)] = false;
                left++;
            }

            vis[s.charAt(right)] = true;
            maxLen = Math.max((right-left+1),maxLen);
        }
        return maxLen;
    }
}
