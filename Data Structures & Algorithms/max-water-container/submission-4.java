class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int currArea = Integer.MIN_VALUE;
        int j = heights.length-1;
        int i = 0;
        while(i<=j)
        {
            currArea = (j-i)*(Math.min(heights[i],heights[j]));
            if(currArea > maxArea){
                maxArea = currArea;
            }
            if(heights[i] > heights[j]){
                j--;
            }
            else if(heights[j] >= heights[i]){
                i++;
            }
        }
        return maxArea;
    }
}
