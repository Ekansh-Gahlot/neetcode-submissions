class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i: piles){
            max = Math.max(i, max);
        }

        int left = 1; 
        int right = max;
        int res = 0;
        while(left <= right){
            int speed = (left+right)/2;
            int time = 0;
            for(int i: piles){
                time += (i+speed-1)/speed; 
            }
            if(time <= h){
                res = speed;
                right = speed-1;
            }
            else{
                left = speed+1;
            }
        }
        return res;
    }
}
