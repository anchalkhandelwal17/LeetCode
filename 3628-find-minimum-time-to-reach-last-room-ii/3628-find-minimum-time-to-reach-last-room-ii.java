class Solution {
    public int minTimeToReach(int[][] moveTime) {
        // TC : O(m*N log(m*n))
        // SC : O(m*n)
        
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] grid = new int[n][m];

        for(int[] arr : grid){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        int[] rowDir = {-1, 0, 1, 0};
        int[] colDir = {0, 1, 0, -1};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0, 1}); // time, x, y, move -> (1 || 2)

        grid[0][0] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int t = curr[0];
            int x = curr[1];
            int y = curr[2];
            int move = curr[3]; // move -> (1 || 2)

            if(x == n-1 && y == m-1) return t;

            for(int k=0; k<4; k++){

                int newX = x + rowDir[k];
                int newY = y + colDir[k];

                if(newX >= 0 && newX < n && newY >= 0 && newY < m){

                    int waitTime = Math.max(0, moveTime[newX][newY] - t);
                    int newTime = t + move + waitTime;


                    if(newTime < grid[newX][newY]){

                        grid[newX][newY] = newTime;
                        pq.offer(new int[]{newTime, newX, newY, move == 1 ? 2 : 1});
                    }
                }
            }

        }

        return -1;
    }
}