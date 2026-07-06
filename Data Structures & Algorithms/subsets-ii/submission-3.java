class Solution {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, 0);
        return ans;
    }
    public void backTrack(int[] nums, int i){
        if(i>=nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        backTrack(nums,i+1);
        temp.remove(temp.size()-1);
        int j = i+1;
        while(j<nums.length && nums[j] == nums[i]){
            j++;
        }
        backTrack(nums,j);
    }
}
