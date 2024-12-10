class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        // TC : O(m + (n^2))
        // SC : O(n + (n^2))
        int[] inDegree = new int[n];
        boolean[][] flag = new boolean[n][n];

        for(int i=0; i<roads.length; i++){
            int u = roads[i][0];
            int v = roads[i][1];

            inDegree[u]++;
            inDegree[v]++;

            flag[u][v] = true;
            flag[v][u] = true;
        }

        int max = 0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){

                if(inDegree[i] + inDegree[j] > max){
                    max = inDegree[i] + inDegree[j];

                    if(flag[i][j]) max--;
                }
            }
        }

        return max;
    }
}