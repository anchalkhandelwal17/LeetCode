class Solution {
    public long maxEnergyBoost(int[] A, int[] B) {
        // TC : O(n)
        // SC : O(n + n) -> for two dp arrays
        int n = A.length;
        long[] dpA = new long[n];
        long[] dpB = new long[n];
        dpA[0] = A[0];
        dpB[0] = B[0];

        for(int i=1; i<n; i++){

            dpA[i] = dpA[i-1] + A[i];
            dpB[i] = dpB[i-1] + B[i];

            if(i >= 2){
                dpA[i] = Math.max(dpA[i], A[i] + dpB[i-2]);
                dpB[i] = Math.max(dpB[i], B[i] + dpA[i-2]);
            }
        }
        return (Math.max(dpA[n-1], dpB[n-1]));
    }
}