class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int n = nums.length;


        for(int i = n-1; i>=0; i--){
            for(int j = i+1; j < n; j++){
                if(nums[j] > nums[i]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
