class Solution {
    public String reverseWords(String s) {
        List<String> arr = new ArrayList<>();
        int i = 0;
        int n = s.length();
        while(i < n){
            while(i <n && s.charAt(i) == ' ') i++;
            int start = i;
            while(i < n && s.charAt(i) != ' ') i++;
            if(start < i){
                arr.add(s.substring(start,i));
            }
        }
        int l = 0;
        int r = arr.size()-1;
        while(l < r){
            String temp = arr.get(l);
            arr.set(l,arr.get(r));
            arr.set(r ,temp);
            l++;
            r--;
        }
        
        return String.join(" " ,arr);
    }
}
