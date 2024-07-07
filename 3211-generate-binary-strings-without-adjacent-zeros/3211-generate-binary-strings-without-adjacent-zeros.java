class Solution {
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        ans.add("0");
        ans.add("1");
        if(n == 1) return ans;

        for(int i=2; i<=n; i++){
            List<String> temp = new ArrayList<>();
            for(String s : ans){
                if(s.charAt(s.length()-1) == '0'){
                    temp.add(s + "1");
                }
                else{
                    temp.add(s + "1");
                    temp.add(s + "0");
                }
            }
            ans = temp;
        }
        return ans;
    }
}