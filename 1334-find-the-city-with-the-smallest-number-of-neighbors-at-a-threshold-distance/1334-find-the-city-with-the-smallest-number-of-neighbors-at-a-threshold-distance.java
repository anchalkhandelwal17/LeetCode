class Pair {
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // TC : O(n * elogv)
        // SC : O(n * n)
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int m = edges.length;
        for(int i=0; i<m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        int ansCity = -1;
        int minCnt = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            int[] dist = new int[n];
            Arrays.fill(dist, (int)(1e9));

            dist[i] = 0;
            pq.offer(new int[]{i, 0});

            while(!pq.isEmpty()){
                int node = pq.peek()[0];
                int dis = pq.peek()[1];
                pq.poll();

                for(Pair P : adj.get(node)){
                    int v = P.first;
                    int wt = P.second;

                    if(dis + wt < dist[v] && dis + wt <= distanceThreshold){
                        dist[v] = dis + wt;
                        pq.offer(new int[]{v, dis + wt});
                    }
                }
            }

            int cnt = 0;
            for(int k=0; k<n; k++){
                if(dist[k] != 1e9){
                    cnt++;
                }
            }
            if(cnt <= minCnt){
                minCnt = cnt;
                ansCity = i; 
            }
        }
        return ansCity; 
    }
}