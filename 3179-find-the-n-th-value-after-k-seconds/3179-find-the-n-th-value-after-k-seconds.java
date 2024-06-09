class Solution {
    public int valueAfterKSeconds(int n, int k) {
        // TC : O(k * n)
        // SC : O(n)
        long[] arr = new long[n];
        Arrays.fill(arr, 1);
        int mod = (int)(1e9+7);
        for(int i=0; i<k; i++){
            for(int j=1; j<n; j++){
                arr[j] = (arr[j] + arr[j-1]) % mod;
            }
        }
        return (int)(arr[n-1] % mod);
    }
}