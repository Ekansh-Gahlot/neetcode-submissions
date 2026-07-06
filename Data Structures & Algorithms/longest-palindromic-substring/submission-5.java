class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            int left = i;
            int right = i;
            int len = 0;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                len = right-left+1;
                if(len > maxLen){
                    maxLen = len;
                    res = s.substring(left, right+1);
                }
                left--;
                right++;
            }
            left = i;
            right = i+1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                len = right-left+1;
                if(len > maxLen){
                    maxLen = len;
                    res = s.substring(left, right+1);
                }
                left--;
                right++;
            }
        }
        return res;
    }
}
