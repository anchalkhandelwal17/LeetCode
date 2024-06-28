class Solution {
    public long maximumImportance(int n, int[][] roads) {
        Map<Integer,Integer> map = new HashMap<>();
        int m = roads.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            map.put(u, map.getOrDefault(u, 0)+1);
            map.put(v, map.getOrDefault(v, 0)+1);
            adj.get(u).add(v);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        for(int k : map.keySet()){
            int val = map.get(k);
            pq.offer(new int[]{k, val});
        }

        int[] cityVal = new int[n];
        int num = n;
        while(!pq.isEmpty()){
            int city = pq.peek()[0];
            pq.poll();
            cityVal[city] = num;
            num--;
        }

        long sum = 0;
        for(int i=0; i<n; i++){
            for(int it : adj.get(i)){
                sum = sum + cityVal[i] + cityVal[it];
            }
        }
        
        return sum;  
    }
}