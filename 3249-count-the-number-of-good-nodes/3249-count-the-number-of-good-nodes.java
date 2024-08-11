class Solution {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public int countGoodNodes(int[][] edges) {
        // TC : O(v + 2e)
        // SC : O(v + 2e for adj list + v for storing the size of the subtrees + 
        //   +  v for dfs)
        int n = edges.length + 1;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] treeSizes = new int[n];
        dfs(0, -1, treeSizes);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int prevSize = -1;
            boolean flag = true;
            for (int nbr : adj.get(i)) {
                if (treeSizes[nbr] < treeSizes[i]) {
                    if (prevSize == -1) {
                        prevSize = treeSizes[nbr];
                    } else if (treeSizes[nbr] != prevSize) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag)
                ans++;
        }
        return ans;
    }

    int dfs(int node, int parent, int[] treeSizes) {
        int size = 1;

        for (int nbr : adj.get(node)) {
            if (nbr != parent) {
                size += dfs(nbr, node, treeSizes);
            }
        }
        return treeSizes[node] = size;
    }
}