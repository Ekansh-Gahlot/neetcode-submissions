class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftToRight = new int[nums.length];
        int[] rightToLeft = new int[nums.length];

        leftToRight[0] = 1;
        rightToLeft[nums.length-1] = 1;
        for(int i = 1; i < nums.length; i++){
            leftToRight[i] = leftToRight[i-1]*nums[i-1];
        }
        for(int i = nums.length-2; i >= 0; i--){
            rightToLeft[i] = rightToLeft[i+1]*nums[i+1];
        }

        int[] result = new int[nums.length];

        for(int i = 0 ; i < nums.length; i++){
            result[i] = leftToRight[i] * rightToLeft[i];
        }
        return result;
    }
}  
