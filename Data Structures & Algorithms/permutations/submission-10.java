class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    List<Integer> permute = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] permute = new boolean[nums.length];
        dfs(nums, permute, 0);
        return list;
    }

    public void dfs(int[] nums, boolean[] permute, int i){
        if(i >= nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int k = 0; k < nums.length; k++){
            if(!permute[k])
            {
                permute[k] = true;
                temp.add(nums[k]);
                dfs(nums, permute, i+1);
                permute[k] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
