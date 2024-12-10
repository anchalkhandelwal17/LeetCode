class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // TC : O(m + n)
        // SC : O(n)
        int[] inDegree = new int[n];
        for(int i=0; i<edges.size(); i++){
            inDegree[edges.get(i).get(1)]++;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0) ans.add(i);
        }

        return ans;
    }
}