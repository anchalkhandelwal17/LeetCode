class Solution {
    public int findChampion(int n, int[][] edges) {
        // TC : O(m + n)
        // SC : O(n)
        int m = edges.length;
        int[] inDegree = new int[n];
        for(int i=0; i<m; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            inDegree[v]++;
        }

        int winner = -1;
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                if(winner == -1){
                    winner = i;
                }
                else return -1;
            }
        }
        return winner;
    }
}