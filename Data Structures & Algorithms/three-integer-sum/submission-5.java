class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            int first = nums[i];

            int left = i+1;
            int right = nums.length-1;

            while(left<right){
                int sum = first + nums[left] + nums[right];

                if(sum < 0){
                    left++;
                }
                else if(sum > 0){
                    right--;
                }
                else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(first);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    set.add(temp);
                    left++;
                    right--;
                }
            }
      
        }
            List<List<Integer>> list = new ArrayList<>(set);
            return list;
    }
}
