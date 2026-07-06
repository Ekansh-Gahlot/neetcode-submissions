class Solution {
    public int[] productExceptSelf(int[] nums) {
        int productNum = 1;
        int c = 0;
        int zeroIndex = -1;

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                c++;
                zeroIndex = i;
            }
            
        }

        for(int n: nums)
        {
            if(n!=0)
            productNum *= n;
        }

        for(int i = 0; i < nums.length; i++)
        {
            if(c>1)
            {
                nums[i] = 0;
            }
            else if(c == 1)
            {
                if(i == zeroIndex) nums[i] = productNum;
                else nums[i] = 0;
            }
            else
            nums[i] = productNum/nums[i];
        }
        return nums;
    }
}  
