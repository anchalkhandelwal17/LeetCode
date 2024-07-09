class Solution {
    public double averageWaitingTime(int[][] customers) {
        // TC : O(n)
        // SC : O(1)
        int n = customers.length;
        double avgWaitingTime = 0.0;
        long startTime = customers[0][0];

        for(int i=0; i<n; i++){
            int arrival = customers[i][0];
            int time = customers[i][1];
            if(arrival > startTime){
                startTime = arrival;
            }
            startTime += time;
            avgWaitingTime = avgWaitingTime + (startTime - arrival);
        }
        return (double)(avgWaitingTime/n);
    }
}

