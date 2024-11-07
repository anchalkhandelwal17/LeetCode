class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // TC : O(rooms + keys)
        // SC : O(rooms) + dfs space
        int n = rooms.size();
        boolean[] vis = new boolean[n];

        dfs(0, rooms, vis);

        int cnt = 0;
        for(int i=0; i<n; i++){
            if(vis[i]) cnt++;
        }
        return cnt == n;
    }

    public void dfs(int node, List<List<Integer>> rooms, boolean[] vis){
        vis[node] = true;

        for(int nbr : rooms.get(node)){
            if(vis[nbr] == false){
                dfs(nbr, rooms, vis);
            }
        }
    }
}