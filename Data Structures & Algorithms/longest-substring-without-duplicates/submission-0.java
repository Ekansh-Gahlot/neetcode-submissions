class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean visited[] = new boolean[256];
        int left = 0;
        int right = 0;
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++)
        {
            while(visited[s.charAt(right)])
            {
                visited[s.charAt(left)] = false;
                left++;
            }
            visited[s.charAt(right)] = true;
            maxLen = Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}
