class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // bfs

        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            q1.offer(new int[]{0, i});
            pacific[0][i] = true;
            q2.offer(new int[]{m-1, i});
            atlantic[m-1][i] = true;
        }

        for(int i=0; i<m; i++){
            q1.offer(new int[]{i, 0});
            pacific[i][0] = true;
            q2.offer(new int[]{i, n-1});
            atlantic[i][n-1] = true;
        }

        int[] rowDir = {-1, 0, 1, 0};
        int[] colDir = {0, 1, 0, -1};
        while(!q1.isEmpty()){

            int currRow = q1.peek()[0];
            int currCol = q1.peek()[1];
            int currHeight = heights[currRow][currCol];
            q1.poll();

            for(int i=0; i<4; i++){
                int nRow = currRow + rowDir[i];
                int nCol = currCol + colDir[i];

                if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n
                && heights[nRow][nCol] >= currHeight && 
                pacific[nRow][nCol] == false){
                    pacific[nRow][nCol] = true;
                    q1.offer(new int[]{nRow, nCol});
                }
            }
        }

        while(!q2.isEmpty()){

            int currRow = q2.peek()[0];
            int currCol = q2.peek()[1];
            int currHeight = heights[currRow][currCol];
            q2.poll();

            for(int i=0; i<4; i++){
                int nRow = currRow + rowDir[i];
                int nCol = currCol + colDir[i];

                if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n
                && heights[nRow][nCol] >= currHeight && 
                atlantic[nRow][nCol] == false){
                    atlantic[nRow][nCol] = true;
                    q2.offer(new int[]{nRow, nCol});
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
}