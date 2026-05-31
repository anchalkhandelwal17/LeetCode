class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[][] dp = new int[n+1][budget+1];
        int[] free = new int[n];

        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min = Math.min(min, items[i][1]);

            for(int j=0; j<n; j++){
                if(i != j && items[j][0] % items[i][0] == 0){
                    free[i]++;
                }
            }
        }

        return solve(items, budget, 0, free, min, dp);
    }

        public int solve(int[][] items, int budget, int i, int[] free, int min, int[][] dp){
            // base case
            if(i >= items.length){
                return budget / min;
            }

            if(dp[i][budget] != -1){
                return dp[i][budget];
            }

            int take = 0;
            if(budget - items[i][1] >= 0){
                take = free[i] + 1 + solve(items, budget - items[i][1], i+1, free, min, dp);
            }

            int not_take = solve(items, budget, i+1, free, min, dp);

            return dp[i][budget] = Math.max(take, not_take);
        }
    }