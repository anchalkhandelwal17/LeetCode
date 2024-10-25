class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        int n = folder.length;

        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);

        for(int i=1; i<n; i++){
            String lastF = ans.get(ans.size()-1);
            lastF += "/";

            if(!folder[i].startsWith(lastF)){
                ans.add(folder[i]);
            }
        }
        return ans;
    }
}