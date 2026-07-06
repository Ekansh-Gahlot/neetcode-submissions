class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backTrack(nums, 0, target);
        return list;
    }
    public void backTrack(int[] nums, int i, int target){
        if(target < 0 || i >= nums.length)
        return;
        if(target == 0){
            list.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        backTrack(nums, i, target-nums[i]);
        temp.remove(temp.size()-1);
        backTrack(nums, i+1, target);
    }
}
