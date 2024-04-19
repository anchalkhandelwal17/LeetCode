class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // dfs
        
        int n = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] vis = new int[n];
        int[] mark = new int[n];
        int[] pathVis = new int[n];
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            for(int it : graph[i]){
                adj.get(i).add(it);
            }
        }
        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                dfs(i, adj, vis, pathVis, mark);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(mark[i] == 1){
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
    int[] vis, int[] pathVis, int[] mark){

        vis[node] = 1;
        pathVis[node] = 1;

        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfs(it, adj, vis, pathVis, mark)){
                    return true;
                }
            }
            else if(pathVis[it] == 1){
                return true;
            }
        }
        mark[node] = 1;
        pathVis[node] = 0;
        return false;
    }
}