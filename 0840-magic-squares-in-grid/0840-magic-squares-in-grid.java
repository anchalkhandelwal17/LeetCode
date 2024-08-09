class Solution {
    public int numMagicSquaresInside(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int rTill = i+2;
                int cTill = j+2;
                if(rTill >= m || cTill >= n) continue;
                else{
                    Set<Integer> set = new HashSet<>();
                    for(int k=i; k<i+3; k++){
                        for(int l=j; l<j+3; l++){
                            int val = grid[k][l];
                            if(val >= 1 && val <= 9){
                                set.add(val);
                            }
                        }
                    }
            
                    if(set.size() == 9){
                        int sum = 15;
                        boolean flag = true;
                    
                        for(int k=i; k<i+3; k++){
                            int temp = 0;
                            for(int l=j; l<j+3; l++){
                                temp += grid[k][l];
                            }
                            if(temp != sum) {
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            for(int k=j; k<j+3; k++){
                                int temp = 0;
                                for(int l=i; l<i+3; l++){
                                    temp += grid[l][k];
                                }
                                if(temp != sum) {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        if(flag){
                            int temp = 0;
                            int r = i;
                            for(int k=j; k<j+3; k++){
                                temp += grid[r++][k];
                            }
                            if(temp == 15){
                                temp = 0;
                                r = i;
                                for(int k=j+3-1; k>=j; k--){
                                    temp += grid[r++][k];
                                }
                                if(temp == sum) ans++;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}