class Solution {
    boolean[] pick;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        pick = new boolean[nums.length];
        dfs(nums);
        return res;
    }

    public void dfs( int[] nums){
        if(temp.size() == nums.length)
        {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int k = 0 ; k < nums.length; k++){
            if(!pick[k]){
                pick[k] = true;
                temp.add(nums[k]);
                dfs(nums);                pick[k] = false;

                temp.remove(temp.size()-1);
            }
        }
    }
}
