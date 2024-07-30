class Solution {
    public int minimumDeletions(String s) {
        // TC : O(n), SC : O(n)
        int moves = 0, n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(!st.isEmpty() && st.peek() == 'b' && c == 'a'){
                moves++;
                st.pop();
            }
            else st.push(c);
        }
        return moves;
    }
}