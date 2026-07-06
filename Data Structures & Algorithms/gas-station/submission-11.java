class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int currGas = 0;
        int start = 0;
        
        for(int i = 0 ; i < gas.length; i++){
            int consume = gas[i] - cost[i];
            totalGas += consume;
            currGas += consume;
            if(currGas < 0){
                currGas = 0;
                start = i+1;
            }
        }

        return totalGas >= 0 ? start : -1;
    }
}
