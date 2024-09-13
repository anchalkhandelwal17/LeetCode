class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // TC : quadratic
        // SC : O(n)
        int n = queries.length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            int xor = 0;
            for(int j=queries[i][0]; j<=queries[i][1]; j++){
                xor ^= arr[j];
            }
            ans[i] = xor;
        }
        return ans;
    }
}

// we can apply brute for, but that'll be quadratic time complexity
// lets think of some other approach with better time complexity