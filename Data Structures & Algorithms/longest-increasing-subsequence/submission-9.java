class Solution {
    public int lengthOfLIS(int[] nums) {
        int arr[] = new int[nums.length];
        Arrays.fill(arr,1);

        for(int i = nums.length-1; i >=0; i--){
            for(int j = i; j < nums.length; j++){
                if(nums[j] > nums[i]){
                    arr[i] = Math.max(arr[i], 1+arr[j]);
                }
            }
        }
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            result = Math.max(result, arr[i]);
        }
        return result;
    }
}
