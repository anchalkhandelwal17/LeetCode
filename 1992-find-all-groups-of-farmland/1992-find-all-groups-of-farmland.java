class Solution {
    public int[][] findFarmland(int[][] land) {
        
        int m = land.length;
        int n = land[0].length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(land[i][j] == 1){
                    int r1 = i;
                    int c1 = j;

                    int[] bottomRightCo = bfs(i, j, land);

                    int r2 = bottomRightCo[0];
                    int c2 = bottomRightCo[1];

                    list.add(Arrays.asList(r1, c1, r2, c2));
                }
            }
        }

        int[][] ans = new int[list.size()][4];
        for(int i=0; i<list.size(); i++){
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
            ans[i][2] = list.get(i).get(2);
            ans[i][3] = list.get(i).get(3);
        }
        return ans;
    }

    public int[] bfs(int i, int j, int[][] land){

        int m = land.length;
        int n = land[0].length;
        int r2 = i;
        int c2 = j;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        int[] rowDir = {-1, 0, 1, 0};
        int[] colDir = {0, 1, 0, -1};
        land[i][j] = -1;

        while(!q.isEmpty()){
            int currRow = q.peek()[0];
            int currCol = q.peek()[1];
            r2 = currRow;
            c2 = currCol;
            q.poll();

            for(int k=0; k<4; k++){
                int nebRow = currRow + rowDir[k];
                int nebCol = currCol + colDir[k];

                if(nebRow >=0 && nebRow <m && nebCol >=0 && nebCol <n
                && land[nebRow][nebCol] == 1){
                    land[nebRow][nebCol] = -1;
                    q.offer(new int[]{nebRow, nebCol});
                }
            }
        }
        return new int[]{r2, c2};
    }
}
// 0 = forested land
// 1 = farmland