class Solution {
    public int lengthOfLIS(int[] nums) {
        int arr[] = new int[nums.length];

        Arrays.fill(arr, 1);

        for(int i = nums.length-1; i>=0 ;i--){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] < nums[j]){
                    arr[i] = Math.max(arr[i], 1+arr[j]);
                }
            }
        }
        int ans = 0;
        for(int i = 0 ; i < arr.length; i++){
            ans = Math.max(ans, arr[i]);
        }
        return ans;
    }
}
