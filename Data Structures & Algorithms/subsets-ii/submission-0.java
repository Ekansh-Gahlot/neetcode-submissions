class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
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
        int next = i + 1;
        while(next < nums.length && nums[i] == nums[next])
        next++;
        dfs(nums, next, temp, res);
    }
}
