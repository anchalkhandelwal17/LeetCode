class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        // TC : O(n * m)
        // SC : O(n)
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;

        HashMap<String, Integer> map = new HashMap<>();
        for(int[] row : matrix){
            StringBuilder sb = new StringBuilder();
            int firstVal = row[0];

            for(int val : row){
                if(val == firstVal){
                    sb.append("T");
                }
                else sb.append("F");
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
        }

        for(int val : map.values()){
            ans = Math.max(ans, val);
        }
        return ans;
    }
}

// 0 1
// 1 0
// ||
// ----

// 1 1
// 0 0


// 0 0 0   -- 1 1 0
// 0 0 1   -- 1 1 1
// 1 1 0   -- 0 0 0

// ttt - 1
// ttf 
// ttf
// ----
// 2