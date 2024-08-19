class Solution {
    public int orangesRotting(int[][] grid) {
        // TC : O(m*n*4)
        // SC : O(m*n)
        // bfs
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1) freshOranges++;
            }
        }
        int totalMinutes = 0;
        int[] rowDir = {-1, 0, 1, 0};
        int[] colDir = {0, 1, 0, -1};

        while(!q.isEmpty()){
            if(freshOranges == 0) break;
            int size = q.size();
            totalMinutes++;
            for(int i=0; i<size; i++){
                int currRow = q.peek()[0];
                int currCol = q.peek()[1];
                q.poll();

                for(int k=0; k<4; k++){
                    int nebRow = currRow + rowDir[k];
                    int nebCol = currCol + colDir[k];

                    if(nebRow >= 0 && nebRow < m 
                    && nebCol >= 0 && nebCol < n
                    && grid[nebRow][nebCol] == 1){
                        freshOranges--;
                        grid[nebRow][nebCol] = 2;
                        q.offer(new int[]{nebRow, nebCol});
                    }
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return totalMinutes;
    }
}