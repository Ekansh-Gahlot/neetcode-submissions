class Solution {
    int[] arr;
    public int rob(int[] nums) {
        arr =new int[nums.length];
        Arrays.fill(arr,-1);
        return dfs(nums,0);
    }

    public int dfs(int[] nums, int i){
        if(i >= nums.length){
            return 0;
        }

        if(arr[i] != -1)
        return arr[i];
        //Rob current house and alternate house or skip current house and rob next one.
        arr[i] = Math.max(nums[i] + dfs(nums,i+2), dfs(nums,i+1));
        return arr[i];
    }
}
