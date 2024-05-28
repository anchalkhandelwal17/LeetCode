class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // BFS
        // TC : O(m*n)
        // SC : O(m*n)
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int sourceCellColor = image[sr][sc];
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int currRow = q.peek()[0];
            int currCol = q.peek()[1];
            q.poll();

            for(int i=0; i<4; i++){
                int nebRow = currRow + delRow[i];
                int nebCol = currCol + delCol[i];

                if(nebRow >= 0 && nebRow < m
                && nebCol >= 0 && nebCol < n
                && image[nebRow][nebCol] == sourceCellColor
                && image[nebRow][nebCol] != color){
                    image[nebRow][nebCol] = color;
                    q.offer(new int[]{nebRow, nebCol});
                }
            }
        }
        return image;
    }
}