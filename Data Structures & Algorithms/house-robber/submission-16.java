class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int rob(int[] nums) {
        return dfs(nums, 0);
    }

    public int dfs(int[] nums, int i){
        if(i >= nums.length)
        return 0;
        if(map.containsKey(i))
        return map.get(i);
        int rob = nums[i] + dfs(nums, i+2);
        int skip = dfs(nums, i+1);

        int money = Math.max(rob, skip);
        map.put(i, money);
        return money;
    }
}
