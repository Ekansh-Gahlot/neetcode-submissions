class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums){
            sum += i;
        }


        if(sum%2!=0)
        return false;

        int target = sum/2;

        return dfs(nums, target, 0);
        
    }

    public boolean dfs(int[] nums, int target, int i){
        if(target == 0)
        return true;

        if(target < 0 || i >= nums.length)
        return false;

        String key = i + "," + target;
        if(map.containsKey(key))
        return map.get(key);

        boolean res = dfs(nums, target-nums[i], i+1) || dfs(nums, target, i+1);
        map.put(key, res);
        return res;
    }
}
