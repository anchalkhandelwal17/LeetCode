class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int start = 0;
        int total = 0;
        int fuel = 0;
        
        for(int i=0; i<cost.length; i++){
            
            fuel += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(fuel < 0){
                fuel = 0;
                start = i+1;
            }
        }
        return total >= 0 ? start : -1;
    }
}