class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int m = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Set<Integer>> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            list.add(new HashSet<>());
            if(inDegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int parent = q.poll();
            for(int node : adj.get(parent)){
                list.get(node).add(parent);
                list.get(node).addAll(list.get(parent));
                --inDegree[node];
                if(inDegree[node] == 0){
                    q.offer(node);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(Set<Integer> s : list){
            ans.add(new ArrayList<>(s));
            Collections.sort(ans.get(ans.size()-1));
        }
        return ans;
    }
}