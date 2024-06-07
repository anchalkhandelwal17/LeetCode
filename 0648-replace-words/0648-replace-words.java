class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {

        HashSet<String> set = new HashSet<>();
        for(int i=0; i<dictionary.size(); i++){
            set.add(dictionary.get(i));
        }
        String[] arr = sentence.split("\\s+");
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            String s = "";
            for(int j=0; j<arr[i].length(); j++){
                s = arr[i].substring(0, j+1);
                if(set.contains(s)){
                    break;
                }
            }
            ans.append(" ");
            ans.append(s);
        }
        ans.deleteCharAt(0);
        return ans.toString();
    }
}