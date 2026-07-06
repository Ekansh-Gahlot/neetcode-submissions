class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int arr[] = new int[26];
        int maxCount = 0;
        int maxLen = 0;
        for(int right = 0; right < s.length(); right++){
            arr[s.charAt(right) - 'A']++;

            maxCount = Math.max(maxCount, arr[s.charAt(right) - 'A']);

            while((right-left+1) - maxCount > k){
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max((right-left+1), maxLen);
        }
        return maxLen;
    }
}
