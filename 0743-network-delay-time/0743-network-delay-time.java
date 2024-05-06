class Pair {
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // TC : O(ElogV)
        // SC : O(V)
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        int m = times.length;
        for(int i=0; i<m; i++){
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)(1e9));
        dist[k] = 0;
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()){
            int time = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();

            for(Pair p : adj.get(node)){
                int v = p.first;
                int wt = p.second;

                if(time + wt < dist[v]){
                    dist[v] = time + wt;
                    pq.offer(new int[]{time + wt, v});
                }
            }
        }
        int minTime = 0;
        for(int i=1; i<dist.length; i++){
            if(dist[i]== 1e9){
                return -1;
            }
            minTime = Math.max(minTime, dist[i]);
        }
        return minTime;
    }
}