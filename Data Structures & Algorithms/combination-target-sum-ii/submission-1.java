class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, temp, res, target);
        return res;
    }

    public void dfs(int[] nums, int i, List<Integer> temp, List<List<Integer>> res, int target){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(i >= nums.length || target < 0)
        return;

        temp.add(nums[i]);
        dfs(nums, i+1, temp, res, target-nums[i]);
        temp.remove(temp.size()-1);
        int next = i+1;
        while(next<nums.length && nums[next] == nums[i])
        next++;
        dfs(nums, next, temp, res, target);
    }
}
