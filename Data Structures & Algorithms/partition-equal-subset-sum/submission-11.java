class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for(int i: nums){
            sum += i;
        }

        if(sum % 2 != 0)
        return false;

        return dfs(nums, 0, sum/2);
        
    }
    public boolean dfs(int[] nums, int i, int target){
        if(target == 0)
        return true;

        String key = i + "/" + target;
        if(map.containsKey(key))
        return map.get(key);

        if(target < 0 || i >= nums.length)
        return false;

        boolean ans = dfs(nums, i+1, target-nums[i]) || dfs(nums, i+1, target);
        map.put(key,ans);
        return ans;
    }
}
