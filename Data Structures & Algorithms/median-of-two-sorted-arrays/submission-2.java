class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length+nums2.length;

        if(totalLen%2!=0){
            return findKth(nums1, nums2, totalLen/2+1);
        }
        else{
            int left = findKth(nums1, nums2, totalLen/2);
            int right = findKth(nums1, nums2, totalLen/2+1);
            return (right+left)/2.0;
        }
    }

    public int findKth(int[] a1, int[] a2, int k){
        int i = 0; int m = a1.length;
        int j = 0; int n = a2.length;
        while(true){
        if(i==m) return a2[j+k-1];
        if(j==n) return a1[i+k-1];
        if(k==1) return Math.min(a1[i], a2[j]);

        int midA = Math.min(i+k/2-1, m-1);
        int midB = Math.min(j+k/2-1, n-1);

        if(a1[midA] < a2[midB]){
            k -= (midA-i+1);
            i = midA+1;
        }
        else{
            k -= (midB-j+1);
            j = midB+1;
        }
        }
    }
}
