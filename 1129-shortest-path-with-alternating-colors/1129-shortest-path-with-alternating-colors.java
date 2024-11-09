class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        ArrayList<ArrayList<Integer>> rEdge = new ArrayList<>();
        ArrayList<ArrayList<Integer>> bEdge = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            rEdge.add(new ArrayList<>());
            bEdge.add(new ArrayList<>());
        }

        for (int i = 0; i < redEdges.length; i++) {
            int a = redEdges[i][0];
            int b = redEdges[i][1];

            rEdge.get(a).add(b);
        }

        for (int i = 0; i < blueEdges.length; i++) {
            int u = blueEdges[i][0];
            int v = blueEdges[i][1];

            bEdge.get(u).add(v);
        }

        boolean[][] vis = new boolean[n][2];
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = 0;
        vis[0][0] = true;
        vis[0][1] = true;

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] { 0, 0 });
        q.offer(new int[] { 0, 1 });

        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int node = q.peek()[0];
                int color = q.peek()[1];

                q.poll();

                if (color == 0) {
                    for (int nbr : rEdge.get(node)) {
                        if (!vis[nbr][1]) { // Replace i with nbr
                            vis[nbr][1] = true;
                            q.offer(new int[] { nbr, 1 });
                            if (ans[nbr] == -1)
                                ans[nbr] = level;
                        }
                    }
                } else {
                    for (int nbr : bEdge.get(node)) {
                        if (!vis[nbr][0]) { // Replace i with nbr
                            vis[nbr][0] = true;
                            q.offer(new int[] { nbr, 0 });
                            if (ans[nbr] == -1)
                                ans[nbr] = level;
                        }
                    }
                }

            }
            level++;
        }
        return ans;
    }
}