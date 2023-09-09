class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<numRows; i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j=1; j<i; j++){
                int val = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
                list.add(j, val);
            }
            if(i != 0){
                list.add(1);
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}