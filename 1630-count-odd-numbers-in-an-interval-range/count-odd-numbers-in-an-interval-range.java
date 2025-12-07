class Solution {
    public int countOdds(int low, int high) {
        int diff = high - low;
        if(low%2 == 1 || high%2 == 1){
            return diff/2 +1;
        }else{
            return diff/2;
        }
    }
}