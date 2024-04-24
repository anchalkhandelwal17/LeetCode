class Solution {
    int[] dp = new int[40];
    public int tribonacci(int n) {
        // recursion
        // TC : O(3^n)
        // SC : O(n) , for stack space
        // if(n == 0) return 0;
        // if(n == 1) return 1;
        // if(n == 2) return 1;
        // return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);

        // memo
        // TC : O(n) 
        // SC : O(n) , for stack space
        // if(n == 0) return 0;
        // if(n == 1) return 1;
        // if(n == 2) return 1;
        // if(dp[n] != 0) return dp[n];

        // return dp[n] = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);

        // tabulation
        // SC : O(n)
        // SC : O(1);

        int[] dp = new int[40];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}