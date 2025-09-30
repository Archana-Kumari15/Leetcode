class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int totalBeauty = 0;
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> freqMap = new HashMap<>();
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                if (freqMap.containsKey(ch)) {
                    freqMap.put(ch, freqMap.get(ch) + 1);
                } else {
                    freqMap.put(ch, 1);
                }
                int maxFreq = Integer.MIN_VALUE;
                int minFreq = Integer.MAX_VALUE;

                for (int freq : freqMap.values()) {
                    maxFreq = Math.max(maxFreq, freq);
                    minFreq = Math.min(minFreq, freq);
                }

                totalBeauty += (maxFreq - minFreq);
            }
        }
        return totalBeauty;
    }
}