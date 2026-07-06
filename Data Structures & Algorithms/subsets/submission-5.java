class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return list;
    }

    public void dfs(int[] nums, int i){
        if(i >= nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        dfs(nums, i+1);
        temp.remove(temp.size()-1);
        dfs(nums, i+1);
    }
}
