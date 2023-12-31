class Solution {
    public String minWindow(String s, String t) {

        if(s.length() < t.length() || s.length() == 0 || t.length() == 0){
            return "";
        }   
        
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }

        int left = 0;
        int minLeft = 0;
        int minLen = s.length()+1;
        int cnt = 0;

        for(int right = 0; right<s.length(); right++){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),map.get(s.charAt(right))-1);
                if(map.get(s.charAt(right)) >= 0){
                    cnt++;
                }
            }

            while(cnt == t.length()){

                if(right - left + 1 < minLen){
                    minLeft = left;
                    minLen = right - left + 1;
                }

                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left),map.get(s.charAt(left))+1);

                    if(map.get(s.charAt(left)) > 0){
                        cnt--;
                    }
                }
                left++;
            }
        }

        return minLen == s.length()+1 ? "" : s.substring(minLeft, minLeft + minLen);
    }
}