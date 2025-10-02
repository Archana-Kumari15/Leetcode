class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int full = numBottles;      
        int empty = 0;              
        int curr = numExchange;     
        int totalDrunk = 0;         

        while (true) {
            boolean progressed = false;

            if (full > 0) {
                totalDrunk += full; 
                empty += full;      
                full = 0;
                progressed = true;
            }
            while (empty >= curr) {
                empty -= curr;  
                full += 1;      
                curr += 1;    
                progressed = true;
            }
            if (!progressed) break;
        }

        return totalDrunk;
    }
}