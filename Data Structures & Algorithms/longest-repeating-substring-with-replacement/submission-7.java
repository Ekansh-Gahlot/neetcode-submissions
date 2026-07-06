class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] freq = new int[26];
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;

            // Keep shrinking until window is valid
            while (!isValid(freq, right - left + 1, k)) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // Helper: check if window is valid using TRUE max frequency
    private boolean isValid(int[] freq, int windowLen, int k) {
        int maxF = 0;
        for (int count : freq) maxF = Math.max(maxF, count);
        return windowLen - maxF <= k;
    }
}
