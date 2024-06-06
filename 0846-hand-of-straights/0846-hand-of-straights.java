class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // TC : O(nlogn)
        // SC : O(n)
        if((hand.length % groupSize ) != 0) return false;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int n = hand.length;
        for(int i=0; i<n; i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0)+1);
            if(map.get(hand[i]) > (n/groupSize)) return false;
        }
        while(map.size() > 0){
            int val = map.firstKey();
            for(int i=0; i<groupSize; i++){
                int currVal = val + i;
                if(!map.containsKey(currVal)){
                    return false;
                }
                else{
                    map.put(currVal, map.getOrDefault(currVal, 0)-1);
                    if(map.get(currVal) == 0){
                        map.remove(currVal);
                    }
                }
            }
        }
        return true;
    }
}