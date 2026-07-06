class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        
        int n = nums.length;
        for(int i = 0; i < n-2; i++)
        {
            
            int a = nums[i];
            if (a > 0) break;
            int left = i+1;
            int right = n-1; 
            while(left < right)
            {
                int sum = nums[left] + nums[right] + a;
                if(sum > 0) right--;
                else if(sum < 0) left++;
                else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(a);
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
