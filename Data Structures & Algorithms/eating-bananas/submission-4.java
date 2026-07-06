class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for(int i: piles){
            max = Math.max(max, i);
        }

        int left = 1;
        int right = max;
        int res = max;

        while(left<=right){
            int speed = (right+left)/2;
            int time = 0;
            int sum = 0;
            for(int i: piles)
            {
                sum+=(i+speed-1)/speed;
            }

            if(sum <= h){
                res = speed;
                right = speed - 1;
            }
            else{
                left = speed+1;
            }
        }
        return res;
    }
}
