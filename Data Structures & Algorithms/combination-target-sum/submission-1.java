class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> temp = new ArrayList<>();
        dfs(nums, 0, temp, target);
        return res;
    }

    public void dfs(int[] nums, int i, List<Integer> temp, int target){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(i >= nums.length || target < 0){
            return;
        }
        temp.add(nums[i]);
        dfs(nums, i, temp, target-nums[i]);
        temp.remove(temp.size()-1);
        dfs(nums, i+1, temp, target);
        
    }
}
