class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];

        backTrack(res, temp, pick, nums);
        return res;
        
    }

    public void backTrack(List<List<Integer>> res, List<Integer> temp, boolean[] pick, int[] nums){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0 ; i < nums.length; i++){
            if(!pick[i]){
                temp.add(nums[i]);
                pick[i] = true;
                backTrack(res, temp, pick, nums);
                temp.remove(temp.size()-1);
                pick[i] = false;
            }
        }
    }
}
