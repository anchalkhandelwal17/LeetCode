class Solution {
    public int regionsBySlashes(String[] grid) {
        // k is avg size of the avg size of the string s in grid
        // TC : O(n * k  + (n * n)*3)
        // SC : O(((n * n)*3) * 2)
        int n = grid.length;
        int[][] mat = new int[n*3][n*3];

        for(int i=0; i<n; i++){
            String s = grid[i];
            for(int j=0; j<s.length(); j++){
                char c = s.charAt(j);
                int rowStart = i * 3;
                int colStart = j * 3;
                if(c == '/'){
                    mat[rowStart][colStart+2] = 1;
                    mat[rowStart+1][colStart+1] = 1;
                    mat[rowStart+2][colStart] = 1;
                }
                else if(c == '\\'){
                    mat[rowStart][colStart] = 1;
                    mat[rowStart+1][colStart+1] = 1;
                    mat[rowStart+2][colStart+2] = 1;
                }
            }
        }

        int ans = 0;
        for(int i=0; i<n*3; i++){
            for(int j=0; j<n*3; j++){
                if(mat[i][j] == 0){
                    ans++;
                    bfs(i, j, mat);
                }
            }
        }
        return ans;
    }
    public void bfs(int i, int j, int[][] mat){
        int m = mat.length;
        int[] rowDir = {-1, 0, 1, 0};
        int[] colDir = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});

        while(!q.isEmpty()){
            int currRow = q.peek()[0];
            int currCol = q.peek()[1];
            q.poll();

            for(int k=0; k<4; k++){
                int nebRow = currRow + rowDir[k];
                int nebCol = currCol + colDir[k];

                if(nebRow >= 0 && nebRow < m
                && nebCol >= 0 && nebCol < m
                && mat[nebRow][nebCol] == 0){
                    mat[nebRow][nebCol] = 1;
                    q.offer(new int[]{nebRow, nebCol});
                }
            }
        }
    }
}