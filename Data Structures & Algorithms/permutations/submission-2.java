class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];
        backTrack(res, temp, nums, pick);
        return res;
    }

    public void backTrack(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] pick){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
        }

        for(int i = 0; i < nums.length; i++){
            if(!pick[i]){
                pick[i] = true;
                temp.add(nums[i]);
                backTrack(res, temp, nums, pick);
                temp.remove(temp.size()-1);
                pick[i] = false;
            }
        }

    }
}
