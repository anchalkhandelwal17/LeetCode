class Solution {
    public int shortestBridge(int[][] grid) {

        // TC : O(n^2)
        // SC : O(n^2)
        int n = grid.length;
        int ans = 0;
        boolean flag = false;
        int[] rowDir = {0, 1, 0, -1};
        int[] colDir = {1, 0, -1, 0};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];

        for(int i=0; i<n; i++){
            if(flag) break;

            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j, q, vis);
                    flag = true;
                    break;
                }
            }
        }

        int flips = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){

                int cRow = q.peek()[0];
                int cCol = q.peek()[1];
                q.poll();

                for(int k=0; k<4; k++){
                    int rNbr = cRow + rowDir[k];
                    int cNbr = cCol + colDir[k];

                    if(rNbr >= 0 && rNbr < n && cNbr >= 0 && cNbr < n && !vis[rNbr][cNbr]){
                        if(grid[rNbr][cNbr] == 1){
                            return flips;
                        }
                        vis[rNbr][cNbr] = true;
                        q.offer(new int[]{rNbr, cNbr});
                    }
                }
            }
            flips++;
        }

        return -1;
    }

    public void dfs(int[][] grid, int i, int j, Queue<int[]> q, boolean[][] vis){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] 
            || grid[i][j] == 0){
            return;
        }

        q.offer(new int[]{i, j});
        vis[i][j] = true;
        dfs(grid, i, j+1, q, vis);
        dfs(grid, i+1, j, q, vis);
        dfs(grid, i, j-1, q, vis);
        dfs(grid, i-1, j, q, vis);
    }
}