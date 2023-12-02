class Solution {
    public int countCharacters(String[] words, String chars) {
        
        int sum = 0;
        
        int[] count = new int[26];
        
        for(int i=0; i<chars.length(); i++){
            count[chars.charAt(i) - 'a']++;
        }
        
        for(int i=0; i<words.length; i++){
           // Method 1 int[] newArr = new int[4]; System.arraycopy(array, 0, newArr, 0, 4);
            
            int[] count2 = new int[26];
            
            System.arraycopy(count, 0, count2, 0, 26);
            boolean flag = true;
            for(int j=0; j<words[i].length(); j++){
                
                if(count2[words[i].charAt(j) - 'a'] == 0){
                    flag = false;
                    break;
                }
                else count2[words[i].charAt(j) - 'a']--;
            }
            
            if(flag == true) sum += words[i].length();
        }
        
        return sum;
    }
}