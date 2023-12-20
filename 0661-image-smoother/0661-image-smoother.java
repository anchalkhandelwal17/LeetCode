class Solution {
    public int[][] imageSmoother(int[][] img) {
        
        int m = img.length;
        int n = img[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                int sum = 0;
                int count = 0;
                
                for(int r=-1; r<=1; r++){
                    for(int c=-1; c<=1; c++){
                        if(r+i >= 0 && r+i < m && c+j >= 0 && c+j < n){
                            sum += img[r+i][c+j] & 255;
                            count++;
                        }
                    }
                }
                img[i][j] |= sum / count << 8;
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                img[i][j] = img[i][j] >> 8;
            }
        }
        return img;
    }
}