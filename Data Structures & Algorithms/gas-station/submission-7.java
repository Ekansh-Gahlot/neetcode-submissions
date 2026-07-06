class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;

        int totalGas = 0;
        int currGas = 0;

        for(int i = 0 ; i < gas.length; i++)
        {
            int gain = gas[i] - cost[i];
            totalGas += gain;
            currGas += gain;

            if(currGas < 0)
            {
                start = i+1;
                currGas = 0;
            }
        }

        return totalGas >=0 ? start:-1;
    }
}
