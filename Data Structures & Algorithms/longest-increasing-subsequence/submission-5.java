class Solution {
    public int lengthOfLIS(int[] nums) {
        int arr[] = new int[nums.length];
        Arrays.fill(arr,1);
        for(int i = nums.length-2; i >= 0 ; i--){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] < nums[j]){
                    arr[i] = Math.max(arr[j]+1,arr[i]);
                }
            }
        }
        int ans = 0;
        for(int i = 0 ; i < nums.length; i++){
            ans = Math.max(ans, arr[i]);
        }
        return ans;
    }
}
