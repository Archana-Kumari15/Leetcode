class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(st.size()>0 && st.peek() == ch){
                st.pop();
            }else st.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(char a : st) sb.append(a);
        return sb.toString();
    }
}