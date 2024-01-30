class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<searchWord.length(); i++){
            String s = searchWord.substring(0, i+1);
            List<String> list = new ArrayList<>();
            int j = 0;
            while(j < products.length && list.size() < 3){
                if(products[j].startsWith(s)){
                    list.add(products[j]);
                }
                j++;
            }
            ans.add(list);
        }
        return ans;
    }
}