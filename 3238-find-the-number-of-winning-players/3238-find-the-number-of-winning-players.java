class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) map.put(i, new ArrayList<>());
        int m = pick.length;
        for(int i=0; i<m; i++){
            int x = pick[i][0];
            int y = pick[i][1];
            map.get(x).add(y);
            // System.out.println("ok");
        }
        
        int ans = 0;
        for(int key : map.keySet()){
            int[] temp = new int[150];
            for(int i=0; i<map.get(key).size(); i++){
                int val = map.get(key).get(i);
                temp[val]++;
            }
            for(int i=0; i<150; i++){
                if(temp[i] >= key+1){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}