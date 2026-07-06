class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];
        backTrack(perm, nums, pick);
        return res;
    }

    public void backTrack(List<Integer> perm, int[] nums, boolean[] pick){
        if(perm.size() == nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!pick[i]){
                perm.add(nums[i]);
                pick[i] = true;
                backTrack(perm, nums, pick);
                perm.remove(perm.size()-1);
                pick[i] = false;  
            }
        }
    }
}
