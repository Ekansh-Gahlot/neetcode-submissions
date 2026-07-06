class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0 ; i < heights.length; i++)
        {
            maxArea = Math.max(maxArea,(right-left)*Math.min(heights[right],heights[left]));
            if(heights[right] > heights[left]) left++;
            else right--;
        }
        return maxArea;
    }
}
