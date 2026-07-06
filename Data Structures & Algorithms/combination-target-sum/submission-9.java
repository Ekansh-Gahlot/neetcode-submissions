class Solution {
    List<List<Integer>> res;
    List<Integer> temp;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        dfs(nums, target, 0);
        return res;
    }


    public void dfs(int[] nums, int target, int i){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(target < 0 || i >= nums.length)
        return;

        temp.add(nums[i]);
        dfs(nums, target-nums[i], i);
        temp.remove(temp.size()-1);
        dfs(nums, target, i+1);
    }
}
