class Solution {
    public List<List<String>> groupAnagrams(String[] s) {
        Map<String,List<String>> map = new HashMap<>();
        for(int i = 0; i<s.length ; i++){
            String str = s[i];
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }  
}