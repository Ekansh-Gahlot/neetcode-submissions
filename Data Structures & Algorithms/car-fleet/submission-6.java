class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] arr = new double[position.length][2];

        for(int i = 0; i < position.length; i++)
        {
            double time = ((double)target-position[i])/speed[i];

            arr[i] = new double[]{time, position[i]};
        }
        int res = 0;
        Arrays.sort(arr, (a,b)->Double.compare(a[1],b[1]));

        double curr = -1;
        int N = position.length;
        for(int i = N-1; i >= 0; i--)
        {
            
            if(arr[i][0] > curr)
            {
                curr = arr[i][0];
                res++;
            }   
        }
        return res;

    }
}
