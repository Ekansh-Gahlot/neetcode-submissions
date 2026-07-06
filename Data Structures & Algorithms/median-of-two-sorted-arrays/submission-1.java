public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;

        if (totalLen % 2 == 1) {
            // Odd length → return the middle element
            return findKth(nums1, nums2, totalLen / 2 + 1);
        } else {
            // Even length → average of middle two
            int left = findKth(nums1, nums2, totalLen / 2);
            int right = findKth(nums1, nums2, totalLen / 2 + 1);
            return (left + right) / 2.0;
        }
    }

    // Finds the k-th smallest element in two sorted arrays
    public int findKth(int[] A, int[] B, int k) {
        int m = A.length, n = B.length;
        int i = 0, j = 0;

        while (true) {
            // If A is exhausted, return from B
            if (i == m) return B[j + k - 1];
            // If B is exhausted, return from A
            if (j == n) return A[i + k - 1];
            // If k == 1, return min of current elements
            if (k == 1) return Math.min(A[i], B[j]);

            // Take k/2 steps in both arrays
            int midA = Math.min(i + k / 2 - 1, m - 1);
            int midB = Math.min(j + k / 2 - 1, n - 1);

            if (A[midA] < B[midB]) {
                k -= (midA - i + 1);
                i = midA + 1;
            } else {
                k -= (midB - j + 1);
                j = midB + 1;
            }
        }
    }
}
