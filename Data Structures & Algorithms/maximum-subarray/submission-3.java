class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int sum = Integer.MIN_VALUE;


        for(int i = 0; i < nums.length; i++)
        {
            currSum += nums[i];
            sum = Math.max(currSum, sum);
            if(currSum <= 0)
            {
                currSum = 0;
            }
        }
        return sum;
    }
}
