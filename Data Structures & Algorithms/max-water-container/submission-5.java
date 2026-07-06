class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        for(int i = 0; i < height.length; i ++){
            int currArea = Math.min(height[left],height[right])*(right-left);
            if(currArea > maxArea){
                maxArea = currArea;
            }
            if(height[left] < height[right]){
                left++;
            }
            else {
                right--;
            }
        }
        return maxArea;
    }
}
