class Solution {
    public String removeStars(String s) {
        // TC : O(n)
        // SC : O(n)
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '*' && !st.isEmpty()){
                st.pop();
            }
            else{
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            ans.insert(0, st.pop());
        }
        return ans.toString();
    }
}