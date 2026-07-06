class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        

        HashSet<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < n-2; i++)
        {
            int first = nums[i];
            int l = i+1;
            int r = n-1;

            while(l<r)
            {
                int second = nums[l];
                int third = nums[r];

                int sum = first + second + third;

                if(sum < 0) l++;
                else if(sum > 0) r--;
                else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(first);
                    temp.add(second);
                    temp.add(third);
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
