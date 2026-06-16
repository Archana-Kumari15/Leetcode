class Solution {
    public String processStr(String s) {
        StringBuilder res = new StringBuilder();
        
            for(char ch : s.toCharArray()){
                if(Character.isLowerCase(ch)){
                    res.append(ch);
                }
                else if(ch == '*'){
                    if(res.length()>0){
                    res.deleteCharAt(res.length() - 1);
                    }
                }
                if(ch == '%'){
                    res.reverse();
                }
                if(ch == '#'){
                    res.append(res.toString());
                }
            }
            return res.toString();    
    }
}