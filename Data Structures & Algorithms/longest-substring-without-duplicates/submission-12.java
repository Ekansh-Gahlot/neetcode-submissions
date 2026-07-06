class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] seen = new int[256];
        int right = 0;
        int left = 0;
        int maxLen = 0;
        while(right < s.length()){
            if(seen[s.charAt(right)]!=0){
                while(left < s.length() && seen[s.charAt(right)] != 0){
                    seen[s.charAt(left)]--;
                    left++;
                }
            }
            seen[s.charAt(right)]++;
            maxLen = Math.max(maxLen, right-left+1);  
            right++;
        }
        return maxLen;
    }
}
