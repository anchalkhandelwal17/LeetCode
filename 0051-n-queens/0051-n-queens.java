class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new  char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        helper(0, board,res);
        return res;
    }

    public void helper(int col, char[][] board, List<List<String>> res){
        if(col == board.length){
            res.add(construct(board));
            return;
        }

        for(int row=0; row<board.length; row++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                helper(col+1, board, res);
                board[row][col] = '.';
            }
        }
    }

    // function to check if a queen can be placed in a particular cell
    public boolean isSafe(char[][] board, int row, int col){
        int originalRow = row;
        int originalCol = col;

        // check for upper diagonal
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }

        row = originalRow;
        col = originalCol;
        // check for lower diagonal
        while(row < board.length && col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row++;
            col--;
        } 
        row = originalRow;
        col = originalCol;
        // check for horizontal left
        while(col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
        }
        return true;
    }

    public List<String> construct(char[][] board){
        List<String> res = new LinkedList<>();
        for(int i=0; i<board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}