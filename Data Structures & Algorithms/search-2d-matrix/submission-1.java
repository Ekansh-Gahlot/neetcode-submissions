class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] mat: matrix){
            if(target >= mat[0] && target <= mat[mat.length-1]){
                return binarySearch(mat, target);
            }
        }
        return false;
    }


    public boolean binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid] == target) return true;
            if(arr[mid] > target){
                right = mid-1; 
            }
            else{
                left = mid+1;
            }
        }
        return false;
    }
}
