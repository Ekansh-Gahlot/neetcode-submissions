class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        dfs(res, nums, temp, 0, target);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, List<Integer> temp, int i, int target){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(target < 0 || i >= nums.length){
            return;
        }
        temp.add(nums[i]);
        dfs(res, nums, temp, i, target-nums[i]);
        temp.remove(temp.size()-1);
        dfs(res, nums, temp, i+1, target);

    }
}
