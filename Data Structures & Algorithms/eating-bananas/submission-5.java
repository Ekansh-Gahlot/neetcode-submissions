class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i: piles)
        {
            max = Math.max(max, i);
        }


        int left = 1;
        int right = max;
        int ans = 0;

        while(left<=right)
        {
            int speed = (left+right)/2;
            int totalHours = 0;
            for(int i: piles){
                totalHours += (i+speed-1)/speed;
            }
            if(totalHours > h){
                left = speed+1;
            } 
            else{
                right = speed - 1;
                ans = speed; //Update speed only when ans is less than total hours
            }
           
        }
        return ans;
    }
}
