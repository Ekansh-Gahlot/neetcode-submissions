class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backTrack(nums, target, 0);
        return ans;
    }

    public void backTrack(int[] nums,  int target, int i){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0 || i >= nums.length){
            return;
        }
        temp.add(nums[i]);
        backTrack(nums, target-nums[i], i);
        temp.remove(temp.size()-1);
        backTrack(nums, target, i+1);
    }
}
