class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, 0);
        return res;
    }

    public void backTrack(int[] nums, int i){
        if(i == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        backTrack(nums, i+1);
        temp.remove(temp.size()-1);
        int next = i+1;
        while(next < nums.length && nums[next] == nums[i])
        next++;
        backTrack(nums, next);
    }
}
