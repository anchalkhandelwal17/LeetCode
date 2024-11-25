class Solution {
    public boolean rotateString(String s, String goal) {
        // TC : O(n)
        // SC : O(n)
        if(s.length() != goal.length()) return false;
        return (s + s).contains(goal);
    }
}