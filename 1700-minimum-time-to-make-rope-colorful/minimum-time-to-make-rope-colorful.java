class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        if (n <= 1) return 0;

        int total = 0;
        int blockSum = neededTime[0];
        int blockMax = neededTime[0];

        for (int i = 1; i < n; ++i) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                blockSum += neededTime[i];
                blockMax = Math.max(blockMax, neededTime[i]);
            } else {
                total += blockSum - blockMax;
                blockSum = neededTime[i];
                blockMax = neededTime[i];
            }
        }
        total += blockSum - blockMax; 
        return total;
    }
}