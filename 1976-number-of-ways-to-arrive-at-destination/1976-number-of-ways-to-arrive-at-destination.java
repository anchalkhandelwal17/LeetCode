class Pair {
    int first;
    long second;

    public Pair(int first, long second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        // TC : O(E*logV)
        // SC : O(N)
        int src = 0;
        int dst = n - 1;
        int m = roads.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.second, b.second));
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int wt = roads[i][2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        long[] dist = new long[n];
        int[] ways = new int[n];  
        Arrays.fill(dist, (long)(1e15));
        dist[src] = 0;
        ways[src] = 1;
        pq.offer(new Pair(src, 0));
        int mod = (int) (1e9 + 7);

        while (!pq.isEmpty()) {
            int node = pq.peek().first;
            long wt = pq.peek().second;
            pq.poll();

            for (Pair p : adj.get(node)) {
                int adjN = p.first;
                long edW = p.second;

                if (wt + edW < dist[adjN]) {
                    dist[adjN] = wt + edW;
                    pq.offer(new Pair(adjN, wt + edW));
                    ways[adjN] = ways[node];
                }
                else if(wt + edW == dist[adjN]){
                    ways[adjN] = (ways[adjN] + ways[node]) % mod;
                }
            }
        }
        return (ways[n-1]%mod);
    }
}