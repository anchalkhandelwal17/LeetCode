class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // TC : O(n*m*4)
        // SC : O(n*m)
        int srcClr = image[sr][sc]; // src clr
        int[] rDir = {-1, 0, 1, 0};
        int[] cDir = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        boolean[][] vis = new boolean[image.length][image[0].length];
        vis[sr][sc] = true;
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int k=0; k<4; k++){
                    int nbrR = r + rDir[k];
                    int nbrC = c + cDir[k];

                    if(nbrR >= 0 && nbrR < image.length 
                    && nbrC >=0 && nbrC < image[0].length
                    && image[nbrR][nbrC] == srcClr && !vis[nbrR][nbrC]){
                        vis[nbrR][nbrC] = true;
                        q.offer(new int[]{nbrR, nbrC});
                        image[nbrR][nbrC] = color;
                    }
                }
            }
        }

        return image;
    }
}
