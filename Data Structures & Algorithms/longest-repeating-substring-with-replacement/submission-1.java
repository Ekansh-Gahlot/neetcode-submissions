class Solution {
    public int characterReplacement(String s, int k) {
        int maxCount[] = new int[256];
        int maxLen = 0;
        int left = 0;
        int ans = 0;

        for(int right = 0 ; right < s.length(); right++)
        {
            maxCount[s.charAt(right) - 'A']++;
            maxLen = Math.max(maxLen, maxCount[s.charAt(right) - 'A']);
            while(((right-left+1) - maxLen) > k){
                maxCount[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, (right-left+1));
        }
        return ans;
    }
}
