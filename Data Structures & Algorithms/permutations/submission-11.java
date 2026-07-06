class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] pick = new boolean[nums.length];
        backTrack(nums, pick, 0);
        return ans;
    }
    public void backTrack(int[] nums, boolean[] pick, int i){
        if(i == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int k = 0 ; k < nums.length; k++){
            if(!pick[k]){
                pick[k] = true;
                temp.add(nums[k]);
                backTrack(nums, pick, i+1);
                temp.remove(temp.size()-1);
                pick[k] = false;
            }
        }
    }
}
