
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];  // Result array to store the maximums
        Deque<Integer> deque = new ArrayDeque<>();  // Deque to store indices
        int resIndex = 0;  // Index for the result array

        for (int i = 0; i < n; i++) {
            // Step 1: Remove elements not in the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Step 2: Remove elements smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Step 3: Add current element's index to the deque
            deque.offerLast(i);

            // Step 4: Add the current maximum to the result once we have a full window
            if (i >= k - 1) {
                result[resIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
