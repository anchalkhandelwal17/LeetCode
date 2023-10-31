class Solution {
    public int totalFruit(int[] fruits) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        int j = 0;
        int i = 0;

        while(j < fruits.length){
            map.put(fruits[j], map.getOrDefault(fruits[j], 0)+1);

            while(map.size() > 2){
                if(map.containsKey(fruits[i])){
                   map.put(fruits[i], map.getOrDefault(fruits[i], 0)-1);
                   if(map.get(fruits[i]) == 0){
                       map.remove(fruits[i]);
                   }   
                }
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}