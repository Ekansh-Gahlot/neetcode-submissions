class Solution {
    boolean[] pick;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        pick = new boolean[nums.length];
        dfs(pick, nums);
        return res;
    }

    public void dfs(boolean[] pick, int[] nums){
        if(temp.size() == nums.length)
        {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int k = 0 ; k < nums.length; k++){
            if(!pick[k]){
                pick[k] = true;
                temp.add(nums[k]);
                dfs(pick, nums);
                temp.remove(temp.size()-1);
                pick[k] = false;
            }
        }
    }
}
