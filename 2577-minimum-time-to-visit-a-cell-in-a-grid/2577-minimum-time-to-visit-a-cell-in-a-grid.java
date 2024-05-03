class Solution {
    public int minimumTime(int[][] grid) {
        // TC : O(mnlog(mn))
        // SC : O(m*n)
        if(grid[0][1] > 1 && grid[1][0] > 1){
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] vis = new boolean[m][n];
        int[] rowDir = {-1, 0, 1, 0};
        int[] colDir = {0, 1, 0, -1};
        pq.offer(new int[]{0, 0, 0});
        vis[0][0] = true;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0];
            int i = curr[1];
            int j = curr[2];

            if(i == m-1 && j == n-1){
                return time;
            }
            for(int k=0; k<4; k++){

                int nRow = i + rowDir[k];
                int nCol = j + colDir[k];

                if(nRow < 0 || nRow >=m || nCol < 0 
                || nCol >= n || vis[nRow][nCol]){
                    continue;
                }

                if(grid[nRow][nCol] > time+1){
                    int diff = grid[nRow][nCol] - time;

                    if(diff%2 == 0){
                        pq.offer(new int[]{grid[nRow][nCol]+1, nRow, nCol});
                    }
                    else{
                        pq.offer(new int[]{grid[nRow][nCol], nRow, nCol});
                    }
                }
                else{
                    pq.offer(new int[]{time+1, nRow, nCol});
                }
                vis[nRow][nCol] = true;
            }
        }
        return -1;
    }
}