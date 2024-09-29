class Solution {
    public long countOfSubstrings(String word, int k) {
        long ans1 = solve(word, k);
        long ans2 = solve(word, k+1);
        return Math.abs(ans1 - ans2);
    }

    public long solve(String word, int k){
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        long ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int cons = 0;
        int i=0, j=0, n=word.length();
        while(j < n){
            char c = word.charAt(j);
            if(set.contains(c)){
                map.put(c, map.getOrDefault(c, 0)+1);
            }
            else cons++;

            while(cons >= k && map.getOrDefault('a', 0) > 0 
            && map.getOrDefault('e', 0) > 0 &&
            map.getOrDefault('i', 0) > 0 &&
            map.getOrDefault('o', 0) > 0 &&
            map.getOrDefault('u', 0) > 0){

                ans += n-j;
                char ch = word.charAt(i);
                if(set.contains(ch)){
                    map.put(ch, map.getOrDefault(ch, 0)-1);
                }
                else cons--;
                i++;
            }
            j++;
        }
        return ans;
    }
}