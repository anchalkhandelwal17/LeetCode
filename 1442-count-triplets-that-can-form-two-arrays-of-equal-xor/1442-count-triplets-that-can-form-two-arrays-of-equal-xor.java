class Solution {
    public int countTriplets(int[] arr) {
        // TC : O(n^2)
        // SC : O(1)
        int ans = 0;
        int n = arr.length;
        
        for(int i=0; i<n; i++){
            int val = arr[i];
            for(int j=i+1; j<n; j++){
                val ^= arr[j];
                
                if(val == 0) ans = ans + (j - i);
            }
        }
        return ans;
    }
}