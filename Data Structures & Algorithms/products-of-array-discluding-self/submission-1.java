class Solution {
    public int[] productExceptSelf(int[] nums) {
        int leftProduct = 1;
        int arr[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            if(i>0)
            {
                leftProduct *= nums[i-1];
            }
            arr[i] = leftProduct;
        }

        int rightProduct = 1;

        for(int i = nums.length-1; i >= 0; i--)
        {
            if(i < nums.length-1){
                rightProduct *= nums[i+1];
            }
            arr[i] = arr[i]*rightProduct;
        }
        return arr;
    }
}  
