class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=1; i<=numRows; i++){
            ans.add(generateRow(i));
        }
        return ans;
    }

    public ArrayList<Integer> generateRow(int row){
        int ans = 1;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for(int col=1; col<row; col++){
            ans = ans * (row-col);
            ans = ans / col;
            list.add(ans);
        }
        return list;
    }
}