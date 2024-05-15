class Solution {
    public boolean isValid(String s) {
        // TC : O(n)
        // SC : O(n)
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            st.push(c);
            if(c == 'c'){
                char ch = 'c';
                int i=0;
                while(!st.isEmpty() && i<3){
                    if(st.pop() != ch) break;
                    ch--;
                    i++;
                }
                if(i != 3) return false;
            }
        }
        return st.isEmpty();
    }
}