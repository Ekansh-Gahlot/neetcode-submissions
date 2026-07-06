class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> temp = new ArrayList<>();
        backTrack(nums, 0, temp, target);
        return res;
    }

    public void backTrack(int[] nums, int i, List<Integer> temp, int target){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(target < 0 || i >= nums.length){
            return;
        }

        temp.add(nums[i]);
        backTrack(nums, i, temp, target-nums[i]);
        temp.remove(temp.size()-1);
        backTrack(nums, i+1, temp, target);
    }
}
