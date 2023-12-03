class Solution {
    public int distributeCandies(int[] candyType) {
        
        HashSet<Integer> set = new HashSet<>();
        int n = candyType.length;
        
        for(int ele : candyType){
            set.add(ele);
        }
        
        if(set.size()  >= n/2) return n/2;
        else return set.size();
        
    }
}