class Solution {
    int max = 0;

    public int maxUniqueSplit(String s) {
        solve(0, s, new HashSet<>());
        return max;
    }

    public void solve(int idx, String s, HashSet<String> set) {
        // base case
        if (idx >= s.length()) {
            max = Math.max(max, set.size());
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            String str = s.substring(idx, i + 1);

            if (!set.contains(str)) {
                set.add(str);
                solve(i + 1, s, set);
                set.remove(str);
            }
        }
    }
}