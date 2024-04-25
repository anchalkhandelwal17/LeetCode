class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // TC : O(m*n)
        // SC : O(m*n)
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        if(grid[0][0] != 0 || grid[m-1][n-1] != 0) return -1;
        q.offer(new Pair(0, 0));
        int pathLen = 0;
        int[] rowDir = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] colDir = {0, 1, 1, 1, 0, -1, -1, -1};
        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;

        while(!q.isEmpty()){
            pathLen++;
            int size = q.size();

            for(int itr=0; itr<size; itr++){
            int i = q.peek().first;
            int j = q.peek().second;
            q.poll();
            if(i == m-1 && j == n-1){
                return pathLen;
            }

            for(int k=0; k<8; k++){
                int nebRow = i + rowDir[k];
                int nebCol = j + colDir[k];

                if(nebRow >= 0 && nebRow < m && nebCol >= 0 && nebCol < n
                && grid[nebRow][nebCol] == 0 && vis[nebRow][nebCol] == false){
                    vis[nebRow][nebCol] = true;
                    q.offer(new Pair(nebRow, nebCol));
                }
            }
            }

        }
        return -1;
    }
}
