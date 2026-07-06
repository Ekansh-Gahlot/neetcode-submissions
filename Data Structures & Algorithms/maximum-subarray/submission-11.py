class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        curr = nums[0]
        maxRes = nums[0]

        for i in range(1,len(nums)):
            if curr < 0:
                curr = 0;
            
            curr += nums[i]

            maxRes = max(maxRes,curr)
        
        return maxRes
