class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < nums.length-2; i++)
        {
            int f = nums[i];
            if(f > 0) break;
            int l = i+1;
            int r = nums.length-1;

            while(l<r)
            {
                int sum = f+nums[l]+nums[r];

                if(sum > 0) r--;
                else if(sum < 0) l++;
                else
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(f);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    set.add(temp); 
                    l++;
                    r--;
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>(set);
        return list;
    }
}
