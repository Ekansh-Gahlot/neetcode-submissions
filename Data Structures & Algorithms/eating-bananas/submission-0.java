class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int max = 0;
       
        int sum = 0;
        for(int i: piles)
        {
            max = Math.max(max, i);
        }
         int right = max;
        int res = max;

        while(left <= right){
            int k = (left+right)/2;
            int hours = 0;

            for(int i: piles)
            {
                sum += (i + k - 1) / k;
            }
            if(sum <= h)
            {
                res = k;
                right = k-1;
            }
            else{
                left = k+1;
            }
            sum = 0;
        }
        return res;
    }
}
