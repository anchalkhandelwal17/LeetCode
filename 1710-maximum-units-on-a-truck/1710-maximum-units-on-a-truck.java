class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Arrays.sort(boxTypes, (a , b) -> Integer.compare(b[1] , a[1]));
        
        int maxUnits = 0;
        int truckCapacity = truckSize;
        
        for(int i=0; i<boxTypes.length; i++){
            int numberOfBoxes = boxTypes[i][0];
            int numberOfUnitsPerBox = boxTypes[i][1];
            
            if(truckCapacity >= numberOfBoxes){
                maxUnits +=  numberOfBoxes * numberOfUnitsPerBox;
                truckCapacity -= numberOfBoxes;
            }
            else{
                maxUnits += truckCapacity * numberOfUnitsPerBox;
                break;
            }
        }
        return maxUnits;
    }
}