class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(res, temp, nums, 0);
        return res;
    }


    public void backTrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int i){
        if(i >= nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        backTrack(res, temp, nums, i+1);
        temp.remove(temp.size()-1);
        backTrack(res, temp, nums, i+1);
    }
}
