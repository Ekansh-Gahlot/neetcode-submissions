class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        int res = 0;

        for(int right = 0 ; right < s.length(); right++){
            char c = s.charAt(right);
            freq[c-'A']++;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);

            while((right-left+1) - maxFreq > k){
                char ch = s.charAt(left);
                freq[ch-'A']--;
                left++;
            }
            res = Math.max(res, (right-left+1));
        }
        return res;
    }
}
