class Solution {
    public int minimumEffortPath(int[][] heights) {
        // TC : O(m*n log(m*n))
        // SC : O(m * n)
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, 1, 0, -1};

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        while(!pq.isEmpty()){

            int effort = pq.peek()[0];
            int x = pq.peek()[1];
            int y = pq.peek()[2];
            if(x == m-1 && y == n-1) return effort;
            pq.poll();

            for(int k=0; k<4; k++){
                int newX = x + dirX[k];
                int newY = y + dirY[k];

                if(newX >= 0 && newX < m && newY >= 0 && newY < n){

                    int newEffort = Math.max(Math.abs(heights[x][y]-heights[newX][newY]), effort);
                        if(newEffort < dist[newX][newY]) {
                            dist[newX][newY] = newEffort;
                            pq.offer(new int[]{dist[newX][newY], newX, newY});
                        }
                    }
            }
        }
        return dist[m-1][n-1];
    }
}