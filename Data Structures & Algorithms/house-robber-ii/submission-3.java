class Solution {
    int[] dp; 
    public int rob(int[] nums) {
        if(nums.length == 1)
        return nums[0];
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int case1 = dfs(nums,nums.length-1, 0);
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int case2 = dfs(nums, nums.length, 1);

        return Math.max(case1, case2);
        
    }


    public int dfs(int[] nums, int len, int i){
        if(i >= len){
            return 0;
        }

        if(dp[i] != -1)
        return dp[i];

        dp[i] = Math.max(nums[i] + dfs(nums,len,i+2), dfs(nums,len,i+1));

        return dp[i];
    }
}
