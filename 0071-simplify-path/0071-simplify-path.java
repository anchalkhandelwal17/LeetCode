class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] s = path.split("/");

        for(int i=0; i<s.length; i++){
            if(!st.isEmpty() && s[i].equals("..")){
                st.pop();
            }
            else if(!s[i].equals("") && !s[i].equals("..") && !s[i].equals(".")){
                st.push(s[i]);
            }
        }
        if(st.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0, st.pop());
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}