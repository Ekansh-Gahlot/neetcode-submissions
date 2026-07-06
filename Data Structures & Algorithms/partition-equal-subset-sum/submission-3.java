class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n: nums){
            sum += n;
        }
        if(sum % 2 != 0)
        return false;

        return dfs(nums, 0, sum/2);
    }

    public boolean dfs(int[] nums, int i, int target){
        if(target == 0)
        return true;

        String key = i + "," + target;

        if(map.containsKey(key))
        return map.get(key);


        if(i >= nums.length || target < 0)
        return false;

        boolean res =  dfs(nums, i+1, target-nums[i]) || dfs(nums, i+1, target);

        map.put(key, res);
        return res;
    }
}
