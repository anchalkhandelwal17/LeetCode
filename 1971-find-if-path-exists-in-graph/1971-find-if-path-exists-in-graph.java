class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // TC : O(V+2E) 
        // SC : O(V+2E) + O(V) + O(V)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int len = edges.length;
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<len; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] vis = new int[n];
        for(int i=0; i<n; i++){
            if(vis[i] == 0 && i == source){
                if(dfs(i, adj, vis,  destination)){
                    return true;
                }
                else return false;
            }
        }
        return false;
    }
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, 
        int destination){

        vis[node] = 1;
        if(vis[destination] == 1) return true;

        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfs(it, adj, vis, destination)){
                    return true;
                }
            }
        }
        return false;
    }
}