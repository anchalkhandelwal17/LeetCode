class Solution {
    public boolean isAnagram(String s, String t) {
        // TC : O(n)
        // SC : O(n)
        int m = s.length();
        int n = t.length();

        if(m != n) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            char a = s.charAt(i);
            char b = t.charAt(i);

            map.put(a, map.getOrDefault(a, 0)+1);
            map.put(b, map.getOrDefault(b, 0)-1);
        }

        for(Character c : map.keySet()){
            if(map.get(c) != 0) return false;
        }
        return true;
    }
}