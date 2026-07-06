class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int longestConsecutive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int maxLen = 0;
        for(int n: nums){
            if(!set.contains(n-1)){
                int curr = n;
                int currLen = 1;

                while(set.contains(curr+1)){
                    curr=curr+1;
                    currLen++;
                }
                maxLen = Math.max(currLen, maxLen);

            }
        }
        return maxLen;
        
    }
}
