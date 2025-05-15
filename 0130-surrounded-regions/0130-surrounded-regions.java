class Solution {
    public void solve(char[][] board) {
        // TC : O(m*n*4)
        // SC : O(m*n)
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<n; i++){
            if(board[0][i] == 'O') bfs(0, i, m, n, board);
            if(board[m-1][i] == 'O') bfs(m-1, i, m, n, board);
        }

        for(int i=0; i<m; i++){
            if(board[i][0] == 'O') bfs(i, 0, m, n, board);
            if(board[i][n-1] == 'O') bfs(i, n-1, m, n, board);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfs(int i, int j, int m, int n, char[][] board){
        Queue<int[]> q = new LinkedList<>();
        int[] rowDir = {-1, 0, 1, 0};
        int[] colDir = {0, 1, 0, -1};
        q.offer(new int[]{i, j});
        board[i][j] = '#';
        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];

            q.poll();

            for(int k=0; k<4; k++){
                int newRow = row + rowDir[k];
                int newCol = col + colDir[k];

                if(newRow < m && newRow >= 0 &&
                newCol < n && newCol >= 0 &&
                board[newRow][newCol] == 'O'){
                    q.offer(new int[]{newRow, newCol});
                    board[newRow][newCol] = '#';
                }
            }
        }
    }
}