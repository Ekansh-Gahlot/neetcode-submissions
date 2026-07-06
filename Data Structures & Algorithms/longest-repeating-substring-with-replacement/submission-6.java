class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] maxFreq = new int[26];
        int maxF = 0;
        int maxLen = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);

            maxFreq[ch-'A']++;

            maxF = Math.max(maxF, maxFreq[ch-'A']);
            int windowLen = right-left+1;

            if(windowLen-maxF > k){
                maxFreq[s.charAt(left)-'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);

        }
        return maxLen;
    }
}
