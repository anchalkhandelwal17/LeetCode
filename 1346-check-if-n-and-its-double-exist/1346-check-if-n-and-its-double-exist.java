class Solution {
    public boolean checkIfExist(int[] arr) {
        // TC : O(n)
        // SC : O(n)

        int n = arr.length;
        HashSet<Integer> st = new HashSet<>();
        for(int x : arr) st.add(x);

        int cnt = 0;

        for(int x : arr) {
            if(x == 0) cnt++;
            if(x != 0 && st.contains(x*2)) return true;
        }

        return cnt >= 2;
    }
}