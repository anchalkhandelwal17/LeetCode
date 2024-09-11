class Solution {
    public int coinChange(int[] coins, int amount) {
        // TC : O(n * A)
        // SC : O(n * A)
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        for(int[] arr : dp) Arrays.fill(arr, -1);
        int ans = rec(n-1, coins, amount, dp);
        
        if(ans >= Math.pow(10, 9)) return -1;
        return ans;
    }
    
    public int rec(int i, int[] coins, int amount, int[][] dp){
        if(amount == 0) return 0;
        if(amount < 0 || i < 0) return (int)(1e9);
        // if(i == 0){
        //     if(amount % coins[0] == 0){
        //         return amount/coins[0];
        //     }
        //     else return (int)Math.pow(10,9);
        // }
        
        if(dp[i][amount] != -1) return dp[i][amount];
        
        int not_take = 0 + rec(i-1, coins, amount, dp);
        // int take = Integer.MAX_VALUE;
        // if(coins[i] <= amount){
            
        // }
        int take = 1 + rec(i, coins, amount-coins[i], dp);
        return dp[i][amount] = Math.min(not_take, take);
    }
}

// class Solution {
//     public int coinChange(int[] coins, int amount) {
        
//         int n = coins.length;
//         int[] dp = new int[amount+1];
        
//         for(int i=1; i<=amount; i++){
            
//             dp[i] = Integer.MAX_VALUE;
//             for(int coin : coins){
                
//                 if(coin <= i && dp[i - coin] != Integer.MAX_VALUE){
//                     dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
//                 }
//             }
//         }
//        if(dp[amount] == Integer.MAX_VALUE){
//            return -1;
//        }
//         return dp[amount];
//     }
// }