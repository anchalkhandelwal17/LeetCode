class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        
        int m = queries.length;
        int n = nums.length;
        int[] ans = new int[m];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(nums[i] == x){
                if(!map.containsKey(x)){
                    map.put(x, new ArrayList<>());
                }
                map.get(x).add(i);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()){
            for(int i=0; i<map.get(key).size(); i++){
                list.add(map.get(key).get(i));
            }
        }
        if(list.size() == 0){
            for(int i=0; i<m; i++){
                ans[i] = -1;
            }
            return ans;
        }
        for(int i=0; i<m; i++){
            
            int q = queries[i];
            if(list.size() < q ){
                ans[i] = -1;
            }
            else{
                ans[i] = list.get(q-1);
            }
        }
        
        return ans;
    }
}