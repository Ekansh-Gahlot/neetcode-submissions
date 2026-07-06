class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++)
        {
            set.add(nums[i]);
        }
        int c = 0;

        for(int n: nums)
        {
            int k = n;
            if(!set.contains(k-1))
            {
                //do something
                int localC = 0;
                System.out.println("Entered with" + k);
                while(set.contains(k))
                {
                    System.out.println("Looking for" + k);
                    localC++;
                    c = Math.max(c,localC);
                    k++;
                }
            }
            // set.add(n);
        }
        return c;
    }
}
