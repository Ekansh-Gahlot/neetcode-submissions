class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int arr[] = new int[256];

        int right = 0;
        int left = 0;

        int maxLen = 0;

        while(right < s.length()){
            if(arr[s.charAt(right)] == 0){
                arr[s.charAt(right)] = 1;
                right++;
            }
            else{
                maxLen = Math.max(maxLen, right-left);
                arr[s.charAt(left)] = 0;
                left++;
            }
        }
        return Math.max(maxLen, right-left);

        
    }
}
