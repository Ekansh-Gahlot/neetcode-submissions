class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] mergedArr = new int[len1+len2];
        int k = 0;
        for(int i = 0 ; i < nums1.length; i++){
            mergedArr[k] = nums1[i];
            k++;
        }
        for(int i = 0 ; i < nums2.length; i++){
            mergedArr[k] = nums2[i];
            k++;
        }

        Arrays.sort(mergedArr);

        int left = 0;
        int right = mergedArr.length-1;
        int len = mergedArr.length;

        if(len % 2 == 0){
            return (mergedArr[len/2-1]+mergedArr[len/2])/2.0;
        }
        else{
            return mergedArr[len/2];
        }
    }
}
