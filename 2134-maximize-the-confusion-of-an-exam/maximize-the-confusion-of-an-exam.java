class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int i = 0, j = 0;
        int res = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (j < n) {
            char ch = answerKey.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (Math.min(map.getOrDefault('T', 0), map.getOrDefault('F', 0)) > k) {
                char leftChar = answerKey.charAt(i);
                map.put(leftChar, map.get(leftChar) - 1);
                i++;
            }

            res = Math.max(res, j - i + 1);
            j++;
        }

        return res;
    }
}