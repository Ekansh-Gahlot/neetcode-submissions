class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        dfs(nums, 0, res, temp);
        return res;

        
    }

    public void dfs(int[] nums, int i, List<List<Integer>> res, List<Integer> temp){
        if(i >= nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        dfs(nums, i+1, res, temp);
        temp.remove(temp.size()-1);
        dfs(nums, i+1, res, temp);
    }
}
