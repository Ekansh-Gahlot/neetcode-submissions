class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i: piles){
            max = Math.max(max, i);
        }
        int left = 1;
        int right = max;
        int res = 0;
        Arrays.sort(piles);

        while(left <= right){
            int speed = left+(right-left)/2;
            int time = 0;
            for(int i: piles){
                time+= Math.ceil(i/(speed*1.0));
            }
            if(time <= h){
                res = speed;
                right = speed-1;
            }
            if(time > h){
                left = speed+1;
            }

        }
        return res;
    }
}
