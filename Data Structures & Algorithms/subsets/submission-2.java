class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(nums, 0, temp, res);
        return res;
    }

    public void dfs(int[] nums, int i, List<Integer> temp, List<List<Integer>> res){
        if(i >= nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        dfs(nums, i+1, temp, res);
        temp.remove(temp.size()-1);
        dfs(nums, i+1, temp, res);
    }
}
