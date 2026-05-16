class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalKamai = 0;
        int totalKharch = 0;
        for(int g : gas){
            totalKamai += g;
        }
        for(int c : cost){
            totalKharch += c;
        }
        if(totalKamai < totalKharch) return -1;
        int resultIdx = 0;
        int total = 0;
        for(int i = 0; i<n ; i++){
            total += gas[i] - cost[i];
            if(total < 0){
                resultIdx = i + 1;
                total = 0;
            }
        }
        return resultIdx;
    }
}