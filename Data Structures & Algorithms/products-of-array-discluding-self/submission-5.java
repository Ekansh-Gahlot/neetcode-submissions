class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];

        Arrays.fill(arr,1);


        for(int i = 1; i < nums.length; i++){
            arr[i] = arr[i-1] * nums[i-1];
        }
        int[] arr2 = new int[nums.length];
        Arrays.fill(arr2,1);
        for(int i = nums.length-2; i >=0 ; i--){
            arr2[i] = arr2[i+1] * nums[i+1];
        }
        int[] res = new int[nums.length];
       
        for(int i = 0; i < nums.length; i++)
        {
            res[i] = arr[i]*arr2[i];
        }
        return res;
    }
}  
