class Solution {
    public List<List<String>> partition(String s) {
        // TC : O(2^n * n)
        // SC : O(k*x)
        List<List<String>> ans = new ArrayList<>();
        helper(s, 0, new ArrayList<String>(), ans); 
        return ans;
    }

    public void helper(String s, int idx, List<String> list, List<List<String>> ans){
        if(idx >= s.length()){
            ans.add(new ArrayList<String>(list));
            return;
        }

        for(int i=idx; i<s.length(); i++){
            String str = s.substring(idx, i+1);
            if(isPalin(str)){
                list.add(str);
                helper(s, i+1, list, ans);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalin(String str){
        int i = 0;
        int j = str.length()-1;

        while(i <= j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}