class Solution {
    public int numberOfSpecialChars(String word) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            int idxx = i;
            if(map.containsKey(ch)){
                if(ch  >= 65 && ch <= 90) continue;
                map.remove(ch);
            }
            map.put(ch, map.getOrDefault(ch, 0)+idxx);
        }
        
        int cnt = 0;
        for(char c = 'a'; c<='z'; c++){
            if(map.containsKey(c) && map.containsKey(Character.toUpperCase(c)) && map.get(c) < map.get(Character.toUpperCase(c))){
                cnt++;
            }
            
        }
        return cnt;
    }
}