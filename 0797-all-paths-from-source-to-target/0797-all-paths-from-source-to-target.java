class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int i=0; i<n; i++){
            for(int nbr : graph[i]){
                adj.get(i).add(nbr);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);

        dfs(adj, 0, path, ans);
        return ans;
    }

    public void dfs(List<List<Integer>> adj, int node, List<Integer> path, 
    List<List<Integer>> ans){

        if(node == adj.size() - 1){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int nbr : adj.get(node)){
            path.add(nbr);
            dfs(adj, nbr, path, ans);
            path.remove(path.size()-1);
        }
    }
}