class Solution {
    public List<List<String>> partition(String s) {
        // T C: O( (2^n) *k*(n/2) )
        // The space complexity can vary depending upon the length of the answer. k is the average length of the list of palindromes and if we have x such list of palindromes in our final answer. The depth of the recursion tree is n, so the auxiliary space required is equal to the O(n).
        // SC : O(k * x)
        List<List<String>> ans = new ArrayList<>();
        helper(0, s, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(int idx, String s, List<String> temp, List<List<String>> ans){
        // base condition
        if(idx == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx; i<s.length(); i++){
            // checking for every substring if it is a palindrome or not
            if(isPalindrome(s, idx, i)){
                temp.add(s.substring(idx, i+1));
                helper(i+1, s, temp, ans);
                temp.remove(temp.size()-1);
            }
        }
    }

    // function for checking if a substring is palindrome or not
    public boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}