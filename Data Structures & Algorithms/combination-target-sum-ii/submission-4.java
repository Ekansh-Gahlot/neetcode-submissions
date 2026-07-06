class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        backTrack(nums, target, 0);
        return res;
    }
    public void backTrack(int[] nums, int target, int i){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0 || i >= nums.length)
        return;
        temp.add(nums[i]);
        backTrack(nums, target-nums[i], i+1);
        temp.remove(temp.size()-1);
        int next = i+1;
        while(next < nums.length && nums[i] == nums[next])
        next++;
        backTrack(nums, target, next);
    }
}
