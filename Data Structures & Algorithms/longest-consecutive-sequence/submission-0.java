class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        for(int n: nums)
        {
            set.add(n);
        }
        
        int k = -1;
        for(int i = 0; i < nums.length; i++)
        {
            int count = 0;
            k = nums[i];
            if(!set.contains(k-1))
            {
                  while(set.contains(k))
                {
                    count++;
                    k++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}