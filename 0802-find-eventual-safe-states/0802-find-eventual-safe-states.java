class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] inDegree = new int[n];
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            for(int it : graph[i]){
                list.get(it).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> safeNodes = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            safeNodes.add(node);
            for(int it : list.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.offer(it);
                }
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}