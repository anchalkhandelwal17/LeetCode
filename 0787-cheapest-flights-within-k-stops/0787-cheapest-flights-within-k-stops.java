class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // TC : O(V + E)
        // SC : O(V) + Extra O(V + E) for creating the graph if we take that also in consideration
        int m = flights.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            for(int it : flights[i]){
                adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
            }
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        q.offer(new int[]{0, 0, src});
        while(!q.isEmpty()){

            int[] arr = q.poll();
            int stops = arr[0];
            int cost = arr[1];
            int node = arr[2];

            for( Pair it : adj.get(node)){
                int adjN = it.first;
                int edW = it.second;

                if(cost + edW < dist[adjN] && stops <= k){
                    dist[adjN] = cost + edW;
                    q.offer(new int[]{stops+1, cost+edW, adjN});
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}