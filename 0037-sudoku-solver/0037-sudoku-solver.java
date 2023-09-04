class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }        
        public boolean solve(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == '.'){
                    for(char c='1'; c<='9'; c++){
                        if(isValid(board,c, i, j)){
                            board[i][j] = c;
                            
                            if(solve(board) == true){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
        }

        public boolean isValid(char[][] board, char c, int i, int j){
            // for row check
            for(int k=0; k<9; k++){
                if(board[i][k] == c){
                    return false;
                }
                //for column check
                if(board[k][j] == c){
                    return false;
                }
                // for grid check
                if(board[3*(i/3) + k/3][3 * (j/3) + k%3] == c){
                    return false;
                }
            }

            return true;
            
        }
    
}