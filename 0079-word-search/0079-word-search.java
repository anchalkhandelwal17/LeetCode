class Solution {
    public boolean exist(char[][] board, String word) {
        // TC : O(m * n * 4^L)
        // SC : O(m * n)
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(solve(board, word, 0, i, j, vis)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean solve(char[][] board, String word, int idx, int i, int j, boolean[][] vis) {
        if (idx >= word.length())
            return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || vis[i][j] || board[i][j] != word.charAt(idx)) {
            return false;
        }

        vis[i][j] = true;

        boolean flag = solve(board, word, idx + 1, i, j + 1, vis)
                || solve(board, word, idx + 1, i + 1, j, vis)
                || solve(board, word, idx + 1, i, j - 1, vis)
                || solve(board, word, idx + 1, i - 1, j, vis);

        vis[i][j] = false;

        return flag;
    }
}
