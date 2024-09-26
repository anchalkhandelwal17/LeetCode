class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // TC : O(n)
        // SC : O(1)
        int n = cost.length;
        int totalGas = 0;
        int start = 0;
        int currGas = 0;
        for(int i=0; i<n; i++){
            totalGas = totalGas + (gas[i] - cost[i]);
            currGas = currGas + (gas[i] - cost[i]);
            if(currGas < 0){
                currGas = 0;
                start = i+1;
            }
        }
        return (totalGas >= 0) ? start : -1;
    }
}