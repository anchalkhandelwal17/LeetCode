class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<m; i++){
            bfs(i, 0, heights, pacific);
            bfs(i, n-1, heights, atlantic);
        }

        for(int i=0; i<n; i++){
            bfs(0, i, heights, pacific);
            bfs(m-1, i, heights, atlantic);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }
        return ans;
    }

    public void bfs(int i, int j, int[][] heights, boolean[][] vis){

        vis[i][j] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        int[] rowDir = {-1, 0, 1, 0};
        int[] colDir = {0, 1, 0, -1};
        int m = heights.length;
        int n = heights[0].length;

        while(!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.peek()[1];

            q.poll();

            for(int k=0; k<4; k++){
                int newX = x + rowDir[k];
                int newY = y + colDir[k];

                if(newX >= 0 && newX < m && newY >= 0 && newY < n
                    && heights[newX][newY] >= heights[x][y] && !vis[newX][newY]){
                        vis[newX][newY] = true;
                        q.offer(new int[]{newX, newY});
                    }
            }
        }
    }
}