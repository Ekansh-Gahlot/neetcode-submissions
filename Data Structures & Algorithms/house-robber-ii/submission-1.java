class Solution {
    int[] arr1;
    int[] arr2;
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0]; // edge case: single house

        arr1 = new int[nums.length];
        arr2 = new int[nums.length];
        Arrays.fill(arr1,-1);
        Arrays.fill(arr2,-1);

        return Math.max(dfs(nums,0,nums.length-1, arr1), dfs(nums,1, nums.length, arr2));
    }

    public int dfs(int[] nums, int i, int lastIdx, int[] arr){
        if(i >= lastIdx){
            return 0;
        }

        if(arr[i]!=-1){
            return arr[i];
        }

        arr[i] = Math.max(nums[i] + dfs(nums, i+2, lastIdx, arr), dfs(nums, i+1, lastIdx, arr));
        return arr[i];


    }
}

