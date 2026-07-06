class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        backTrack(nums,0,target);
        return list;
    }

    public void backTrack(int[] nums, int i, int target){
        
        if(target == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0 || i >= nums.length){
            return;
        }
       
        
        
        temp.add(nums[i]);
        backTrack(nums, i+1, target-nums[i]);
        temp.remove(temp.size()-1);
        int next = i+1;
        while(next < nums.length && nums[next] == nums[i]){
            next++;
        }
        backTrack(nums, next, target);
    }
}
