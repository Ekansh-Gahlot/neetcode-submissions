class Solution {
    public int lengthOfLongestSubstring(String s) {
        int characterSeen[] = new int[256];
        int left = 0;
        int right = 0;
        int maxWindow = 0;
        int currWindow = 0;
        while(right < s.length())
        {
            char c  = s.charAt(right);
            if(characterSeen[c] == 0)
            {
                characterSeen[c]++;
                currWindow = right-left+1;
                if(currWindow > maxWindow){
                maxWindow = currWindow;
                }
                right++; 
            }
            else{
                characterSeen[s.charAt(left)]--;
                left++;
            }
        }
        return maxWindow;
    }
}
