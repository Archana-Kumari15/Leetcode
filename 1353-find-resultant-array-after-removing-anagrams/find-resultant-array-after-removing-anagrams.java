class Solution {
    public String signature(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
    public List<String> removeAnagrams(String[] words) {
         int n = words.length;
        if (n == 0) return new ArrayList<>();

        int write = 0;
        String sigTop = signature(words[0]);

        for (int i = 1; i < n; i++) {
            String sigI = signature(words[i]);
            if (sigI.equals(sigTop)) {
                continue;
            } else {
                write++;
                words[write] = words[i]; 
                sigTop = sigI;          
            }
        }
        List<String> result = new ArrayList<>(write + 1);
        for (int i = 0; i <= write; i++) result.add(words[i]);
        return result;
    }
}