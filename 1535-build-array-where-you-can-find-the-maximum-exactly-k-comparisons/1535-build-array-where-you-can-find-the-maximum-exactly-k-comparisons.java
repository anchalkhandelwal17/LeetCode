class Solution {
    int N;
    int M;
    int K;
    int mod = 1000000007;
    int[][][] dp = new int[51][51][101];
    public int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return solve(0, 0, 0);
    }

    public int solve(int idx, int searchCost, int maxVal){
        if(idx == N){
            if(searchCost == K){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[idx][searchCost][maxVal] !=-1){
            return dp[idx][searchCost][maxVal];
        }
        int res = 0;

        for(int i=1; i<=M; i++){
            if(i > maxVal){
                res = (res + solve(idx+1, searchCost+1, i))%mod;
            }
            else{
                res = (res + solve(idx+1, searchCost, maxVal)) % mod;
            }
        }

        return dp[idx][searchCost][maxVal] = res % mod;      

    }
}