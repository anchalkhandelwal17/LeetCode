class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // TC : O(n)
        // SC : O(n)
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<manager.length; i++){
            if(manager[i] != -1){
                adj.get(manager[i]).add(i);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{headID, 0});
        int totalTime = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int u = curr[0];
            int t = curr[1];

            totalTime = Math.max(totalTime, t);

            for(int v : adj.get(u)){
                q.offer(new int[]{v, t + informTime[u]});
            }
        }
        return totalTime;
    }
}