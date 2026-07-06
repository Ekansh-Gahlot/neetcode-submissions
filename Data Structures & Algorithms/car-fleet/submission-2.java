class Solution {
    // public int carFleet(int target, int[] position, int[] speed) {
    //     int N = position.length;
    //     double[][] cars = new double[N][2];

    //     for(int i = 0 ; i < position.length; i++){
    //         cars[i] = new double[]{position[i],(double)((target-position[i])/(speed[i]))};
    //     }
    //     Arrays.sort(cars, (a,b)->Double.compare(a[0],b[0]));
    //     double curr = -1;
    //     int res = 0;
    //     for(int i = N-1; i >= 0; i--)
    //     {
    //         if(cars[i][1] > curr)
    //         {
    //             curr = cars[i][1];
    //             res++;
    //         }
    //     }
    //     return res;
    // }
        public int carFleet(int target, int[] pos, int[] speed) {
        int N = pos.length, res = 0;
        double[][] cars = new double[N][2];
        for (int i = 0; i < N; ++i)
            cars[i] = new double[] {pos[i], (double)(target - pos[i]) / speed[i]};
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        double cur = 0;
        for (int i = N - 1; i >= 0 ; --i) {
            if (cars[i][1] > cur) {
                cur = cars[i][1];
                res++;
            }
        }
        return res;
    }
}
