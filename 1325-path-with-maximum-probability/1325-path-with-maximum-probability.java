class Pair {
    int first;
    double second;
    public Pair(int first, double second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // TC : O(elogv)
        // SC : O(n)
        ArrayList<ArrayList<Pair>> adj  = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int m = edges.length;
        for(int i=0; i<m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double wt = succProb[i];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt)); 
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> 
        Double.compare(b.second, a.second));

        pq.offer(new Pair(start_node, 1));
        double[] dist = new double[n];

        while(!pq.isEmpty()){

            int node = pq.peek().first;
            double nodeWt = pq.peek().second;
            pq.poll();

            for(Pair p : adj.get(node)){
                int adjN = p.first;
                double edWt = p.second;
                if(edWt * nodeWt > dist[adjN]){
                    dist[adjN] = edWt * nodeWt;
                    pq.offer(new Pair(adjN, edWt * nodeWt));
                }
            }
        }
        return dist[end_node];
    }
}