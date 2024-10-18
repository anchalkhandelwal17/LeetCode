class Solution {
    public int minInsertions(String s) {
        // TC : O(n^2)
        // SC : O(n^2) + recursion space
        int n = s.length();
        int[][] dp = new int[n+2][n+2];

        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return solve(0, n-1, s, dp);
    }

    public int solve(int i, int j, String s, int[][] dp){
        // base case

        if(i >= j) return 0;
        
        // if chars at index i and j matches no operation is req move i and j

        // if ans is already cahced for this state them return it

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)){
            return solve(i+1, j-1, s, dp);
        }

        // if chars at index i and j do not matches them add matching chars to both the sides
        // adding cost of 2 
        int addSameCharBothTheSides = 2 + solve(i+1, j-1, s, dp);

        // if chars at index i and j do not matches them add matching char to left side
        // adding cost of 1 
        int addSameCharLeftSide = 1 + solve(i, j-1, s, dp);

        // if chars at index i and j do not matches them add matching char to right side
        // adding cost of 1
        int addSameCharBothSide = 1 + solve(i+1, j, s, dp);

        // return min of all the operations
        return dp[i][j] = Math.min(addSameCharBothTheSides,
                Math.min(addSameCharLeftSide, addSameCharBothSide));
    }
}

// if the chars at both the indices (i, j) from front and back matches then no operation
// is required.

// but if not then a operation is req.

// f(i, j) = min(2 + f(i+1, j-1), 1 + f(i, j-1),
//                 1 + f(i+1, j))


// mbdadbm

// base cases

// if(i >= j) return 0