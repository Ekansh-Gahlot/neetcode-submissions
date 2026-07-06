class Solution {
    List<List<Integer>> res;
    List<Integer> temp;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        backTrack(nums, target, 0);
        return res;
    }

    public void backTrack(int[] nums, int target, int i){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(target < 0 || i >= nums.length){
            return;
        }

        temp.add(nums[i]);
        backTrack(nums, target-nums[i], i);

        temp.remove(temp.size()-1);
        backTrack(nums,target, i+1);

    }
}
