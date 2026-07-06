class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currGas = 0;
        int totalGas = 0;
        int start = 0;

        for(int i = 0; i < gas.length; i++){
            int leftGas = gas[i]-cost[i];

            totalGas += leftGas;
            currGas += leftGas;

            if(currGas < 0){
                currGas = 0;
                start=i+1;
            }
        }
        return totalGas >= 0 ? start : -1;
    }
}
