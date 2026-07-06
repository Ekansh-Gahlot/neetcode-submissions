class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int resIndex = 0;

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < nums.length; i++)
        {
            if(!dq.isEmpty() && dq.peekFirst() < (i-k+1))
            {
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
            {
                dq.pollLast();
            }

            dq.offerLast(i);
            
            if(i >= k-1){
                 res[resIndex++] = nums[dq.peekFirst()];
                //  System.out.println(i);
            }
           
        }
        return res; 
    }
}
