class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        boolean[] pick = new boolean[nums.length];

        dfs(nums, pick);
        return list;
        
    }

    public void dfs(int[] nums, boolean[] pick){
        if(temp.size() == nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int k = 0; k < nums.length; k++){
            if(!pick[k]){
                pick[k] = true;
                temp.add(nums[k]);
                dfs(nums, pick);
                pick[k] = false;
                temp.remove(temp.size()-1);
            }
        }
    }

}
