class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        backTrack(res, temp, nums, target, 0);
        return res;
    }

    public void backTrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int target, int i){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(target < 0 || i >= nums.length)
        return;

        temp.add(nums[i]);
        backTrack(res, temp, nums, target-nums[i], i);
        temp.remove(temp.size()-1);
        backTrack(res, temp, nums, target, i+1);


    }
}
