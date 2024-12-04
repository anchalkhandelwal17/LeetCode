class Solution {
    public int closedIsland(int[][] grid) {
        // TC : O(2 * (m*n))
        // SC : O(2 * (m*n))
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int cnt = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0 && !vis[i][j] && bfs(i, j, grid, vis)){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public boolean bfs(int i, int j, int[][] grid, boolean[][] vis){
        int m = grid.length;
        int n = grid[0].length;

        int[] rDir = {-1, 0, 1, 0};
        int[] cDir = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        vis[i][j] = true;
        boolean flag = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            i = curr[0];
            j = curr[1];

            for(int k=0; k<4; k++){
                int nbrRow = i + rDir[k];
                int nbrCol = j + cDir[k];

                if(nbrRow < 0 || nbrRow >= m || nbrCol < 0 || nbrCol >= n){
                    flag = false;
                }
                else if(grid[nbrRow][nbrCol] == 0 && !vis[nbrRow][nbrCol]){
                    q.offer(new int[]{nbrRow, nbrCol});
                    vis[nbrRow][nbrCol] = true;
                }
            }
        }
        return flag;
    }
}