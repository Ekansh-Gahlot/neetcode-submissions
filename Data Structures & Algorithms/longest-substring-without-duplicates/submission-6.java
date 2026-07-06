class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] visited = new boolean[256];
        int left = 0;
        int maxLen = 0;
        for(int right = 0; right < s.length(); right++){
            
            while(visited[s.charAt(right)]){
                visited[s.charAt(left)] = false;
                left++;
            }

            visited[s.charAt(right)] = true;

            maxLen = Math.max(maxLen, (right-left+1));
            
        }
        return maxLen;
    }
}
