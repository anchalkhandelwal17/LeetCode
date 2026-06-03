class Solution {
    public int[] countBits(int n) {
        // TC : O(n * 32)
        // SC : O(n)
        int[] ans = new int[n + 1];
        for(int i=0; i<=n; i++){
            int temp = i;
            int cnt = 0;
            for(int j=0; j<32; j++){
                // temp >>= j;
                if(((temp >> j) & 1) == 1){
                    cnt++;
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }
}