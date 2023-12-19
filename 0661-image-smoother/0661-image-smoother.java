class Solution {
    public int[][] imageSmoother(int[][] img) {
        
        int[][] ans = new int[img.length][img[0].length];
        
        for(int i=0; i<img.length; i++){
            for(int j=0; j<img[0].length; j++){
                
                int count = 0;
                int sum = 0;
                for(int r=-1; r<=1; r++){
                    for(int c=-1; c<=1; c++){
                        if(r+i >= 0 && r+i < img.length && c+j >= 0 && c+j < img[0].length){
                            sum += img[r+i][c+j];
                            count++;
                        }
                    }
                }
                ans[i][j] = sum/count;
            }
        }
        return ans;
    }
}