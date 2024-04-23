class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // TC : O(V+2E)
        // SC : O(V)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int m = edges.length;
        int[] inDegree = new int[n];
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
            inDegree[b]++;
            inDegree[a]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inDegree[i] == 1){
                q.offer(i);
            }
        }
        int len = n;
        while(len > 2){
            int size = q.size();
            len -= size;
            while(size > 0){
                int node = q.poll();

                for(int it : adj.get(node)){
                    inDegree[it]--;
                    if(inDegree[it] == 1){
                        q.offer(it);
                    }
                }
                size--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        
        if(n == 1) ans.add(0);
        return ans; 
    }
}