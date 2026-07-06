class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, 0);
        return list;
    }

    public void dfs(int[] nums, int target, int i){
        if(target == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0 || i >= nums.length)
        return;

        temp.add(nums[i]);
        dfs(nums, target-nums[i], i);
        temp.remove(temp.size()-1);
        int next = i+1;
        while(next < nums.length && nums[i] == nums[next])
        next++;
        dfs(nums, target, next);
    }
}
