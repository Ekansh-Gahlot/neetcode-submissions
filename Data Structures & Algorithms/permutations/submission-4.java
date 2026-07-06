class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] pick = new boolean[nums.length];
        backTrack(nums, pick);
        return res;
    }

    public void backTrack(int[] nums, boolean[] pick){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int k = 0 ; k < nums.length; k++){
            if(!pick[k]){
                pick[k] = true;
                temp.add(nums[k]);
                backTrack(nums, pick);
                pick[k] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
