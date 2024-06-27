class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            map.put(u, map.getOrDefault(u, 0)+1);
            map.put(v, map.getOrDefault(v, 0)+1);
        }

        int max = -1;
        int ans = -1;
        for(int key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                ans = key;
            }
        }
        return ans;
    }
}