class Solution {
    public String losingPlayer(int x, int y) {
        if(x < 1 && y < 4) return "Alice";
        int i = 0;
        
        while(x > 0 && y >= 4){
            i++;
            x -= 1;
            y -= 4;
        }
        if(i % 2 == 1) return "Alice";
        else return "Bob";
    }
}