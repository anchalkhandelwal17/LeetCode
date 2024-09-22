class Solution {
    public String minWindow(String s, String t) {
        // TC : O(m + n)
        // SC : O(n)
        int m = s.length();
        int n = t.length();
        if (m < n)
            return "";

        int size = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        int cnt = 0;
        int i = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int k=0; k<n; k++){
            map.put(t.charAt(k), map.getOrDefault(t.charAt(k), 0)+1);
        }

        for(int j=0; j<m; j++){
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)-1);

                if(map.get(s.charAt(j)) >= 0){
                    cnt++;
                }
            }

            while(cnt == n){

                if(j - i + 1 < size){
                    size = j - i + 1;
                    start = i;
                    end = j;
                }

                if(map.containsKey(s.charAt(i))){
                     map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);

                     if(map.get(s.charAt(i)) > 0){
                        cnt--;
                     }
                }

                i++;
            }
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, end+1);
    }
}