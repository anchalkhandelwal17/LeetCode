class Solution {
    public int minReorder(int n, int[][] connections) {
        // TC : O(n)
        // SC : O(n)
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<connections.length; i++){
            int a = connections[i][0];
            int b = connections[i][1];

            adj.get(a).add(b);
            adj.get(b).add(-a);
        }

        return dfs(adj, new boolean[n], 0);        
    }

    public int dfs(List<List<Integer>> adj, boolean[] flag, int node){
        int ans = 0;
        flag[node] = true;

        for(int nbr : adj.get(node)){
            if(!flag[Math.abs(nbr)]){
                ans += dfs(adj, flag, Math.abs(nbr)) + (nbr > 0 ? 1 : 0);
            }
        }
        return ans;
    }
}