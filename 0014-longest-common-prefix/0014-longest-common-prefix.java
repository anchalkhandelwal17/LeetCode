class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder ans = new StringBuilder();

        for(int i=0; i<strs[0].length(); i++){
            boolean flag = false;
            for(int j=1; j<strs.length; j++){
                if(i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)){
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
            ans.append(strs[0].charAt(i));
        }

        return ans.toString();
    }
}