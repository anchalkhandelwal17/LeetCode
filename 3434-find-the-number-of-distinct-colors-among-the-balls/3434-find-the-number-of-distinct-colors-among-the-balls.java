class Solution {
    public int[] queryResults(int limit, int[][] queries) {

        int n = queries.length;
        int[] ans = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        
        for(int i=0; i<n; i++){
            int x = queries[i][0];
            int y = queries[i][1];
            
            if(map.containsKey(x)){
                map2.put(map.get(x), map2.getOrDefault(map.get(x), 0)-1);
                if(map2.get(map.get(x)) == 0){
                    map2.remove(map.get(x));
                }
            }
            map.put(x, y);
            map2.put(y, map2.getOrDefault(y, 0)+1);
            
            ans[i] = map2.size();
        }
        return ans;
    }
}