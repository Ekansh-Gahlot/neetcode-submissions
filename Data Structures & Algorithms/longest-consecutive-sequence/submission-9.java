class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ; i < nums.length; i++){
            set.add(nums[i]);
        }
        int maxLen = 0;
        for(int i = 0 ; i < nums.length; i++){
            int n = nums[i];
            if(!set.contains(n-1)){
                int len = 1;
                while(set.contains(n+1)){
                    len++;
                    n++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
