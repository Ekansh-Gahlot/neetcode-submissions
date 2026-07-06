class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        double[][] cars = new double[N][2];

        for(int i = 0 ; i < position.length; i++){
            double time = ((double)(target-position[i])/(speed[i]));
            System.out.println("The time for "+position[i]+"is "+time);
            cars[i] = new double[]{position[i],time};
        }
        Arrays.sort(cars, (a,b)->Double.compare(a[0],b[0]));
        double curr = -1;
        int res = 0;
        for(int i = N-1; i >= 0; i--)
        // {System.out.println(cars[i][1]);
        {
            if(cars[i][1] > curr)
            {
                curr = cars[i][1];
                
                res++;
            }
        }
        return res;
    }

}
