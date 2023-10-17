class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> ans = new ArrayList<>();
        solve(0, s, new ArrayList<String>(), ans);

        return ans;
    }

    public void solve(int idx, String s, List<String> list, List<List<String>> ans){
        if(idx == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=idx; i<s.length(); i++){

            if(isPalin(s, idx, i)){
                list.add(s.substring(idx, i+1));
                solve(i+1, s, list, ans);
                list.remove(list.size() -1);
            }
        }
    }

    public boolean isPalin(String str, int i, int j){

        while( i<=j ){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}