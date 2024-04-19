class Solution {
    public boolean isBipartite(int[][] graph) {
        // TC : O(N+2E)
        // SC : O(N) , not considering space used to create adj list.
        // if we take that also in consideration then space used will be O(N+2E)
        int n = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            for(int it : graph[i]){
                adj.get(i).add(it);
            }
        }
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i=0; i<n; i++){
            if(color[i] == -1){
                if(bfs(i, adj, color)){
                    return false;
                }
            }
        }
        return true;   
    }

    public boolean bfs(int node, ArrayList<ArrayList<Integer>> adj, int[]color){
        color[node] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int parentNode = q.peek();
            int parentNodecolor = color[q.peek()];
            q.poll();
            for(int it : adj.get(parentNode)){
                if(color[it] == -1){
                    if(parentNodecolor == 0){
                        color[it] = 1;
                    }
                    else color[it] = 0;
                    q.offer(it);
                }
                else if(color[it] == parentNodecolor){
                    return true;
                }
            }
        }
        return false;
    }
}