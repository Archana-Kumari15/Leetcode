class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrank = numBottles; 
        int empties = numBottles;     
        while (empties >= numExchange) {
            int newFull = empties / numExchange;   
            totalDrank += newFull;                 
            empties = (empties % numExchange) + newFull; 
        }
        return totalDrank;
    }
}