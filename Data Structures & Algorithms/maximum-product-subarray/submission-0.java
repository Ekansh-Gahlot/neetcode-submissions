class Solution {
    public int maxProduct(int[] nums) {
       int min = nums[0];
       int max = nums[0];
       int res = nums[0];

       for(int i = 1 ; i < nums.length; i++){
        int temp = max*nums[i];
         max = Math.max(Math.max(max*nums[i],nums[i]*min),nums[i]);
         min = Math.min(Math.min(min*nums[i],temp),nums[i]);
         res = Math.max(res, max);
       } 
       return res;
    }
}
