class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        // TC : O(n*m*4 + nmlog(nm))
        // SC : O(n*m)
        Arrays.sort(sources, (a, b) -> b[2] - a[2]);
        Queue<int[]> q = new LinkedList<>();
        int[] rowDir = { -1, 0, 1, 0 };
        int[] colDir = { 0, 1, 0, -1 };
        boolean[][] vis = new boolean[n][m];
        int[][] ans = new int[n][m];

        for (int i = 0; i < sources.length; i++) {
            int r = sources[i][0];
            int c = sources[i][1];
            int clr = sources[i][2];
            ans[r][c] = clr;

            q.offer(new int[] { r, c, clr });
            vis[r][c] = true;
        }

        while (!q.isEmpty()) {
            
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int clr = curr[2];

            for (int k = 0; k < 4; k++) {

                int nbrR = r + rowDir[k];
                int nbrC = c + colDir[k];

                if (nbrR >= 0 && nbrR < n && nbrC >= 0 && nbrC < m && !vis[nbrR][nbrC]) {
                    vis[nbrR][nbrC] = true;
                    ans[nbrR][nbrC] = clr;
                    q.offer(new int[] { nbrR, nbrC, clr });
                }
            }
        }
        return ans;
    }
}

// n -> rows
// m -> cols

// Ri, Ci, Clri
