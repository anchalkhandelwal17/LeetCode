class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        StringBuilder sb1 = new StringBuilder();
        
        StringBuilder sb2 = new StringBuilder();
        
        createString(word1, sb1);
        createString(word2, sb2);
        
        return sb1.toString().equals(sb2.toString());
    }
    
    public void createString(String[] word , StringBuilder sb){
        
        for(int i=0; i<word.length; i++){
            sb.append(word[i]);
        }
    }
}