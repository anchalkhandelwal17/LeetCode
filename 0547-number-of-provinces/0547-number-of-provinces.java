class Solution {
    public int findCircleNum(int[][] isConnected) {
        // bfs
        // TC : O(n^2)
        // SC : O(n + n)
        boolean[] vis = new boolean[isConnected.length];

        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<isConnected.length; i++){
            if(!vis[i]){
                cnt++;
                vis[i] = true;
                q.offer(i);

                while(!q.isEmpty()){
                    int j = q.poll();

                    for(int k=0; k<isConnected.length; k++){
                        if(!vis[k] && isConnected[j][k] == 1){
                            vis[k] = true;
                            q.offer(k);
                        }
                    }
                }
            }
        }
        return cnt;
    }
}