class Solution {
    public int maxArea(int[] heights) {
        int l = 0; 
        int r = heights.length-1;
        int maxArea = -1;

        for(int i = 0 ; i < heights.length; i++){
        // while(l<r){
            maxArea = Math.max(maxArea,(r-l)*Math.min(heights[l],heights[r]));
            if(heights[l] > heights[r]){
                r--;
            }
            else l++;
        }
        return maxArea;
    }
}
