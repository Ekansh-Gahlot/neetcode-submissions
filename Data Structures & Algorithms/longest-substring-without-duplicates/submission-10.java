class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] seen = new int[256];
        int maxLen = 0;
        int left = 0;
        int right = 0;
        
        while(right < s.length()){
            if(seen[s.charAt(right)] == 0)
            {
                seen[s.charAt(right)]++;
                right++;
            }
            else{
                maxLen = Math.max(maxLen, right-left);
                seen[s.charAt(left)]--;
                left++;
            }
        }
        return Math.max(maxLen, right-left);
    }
}
