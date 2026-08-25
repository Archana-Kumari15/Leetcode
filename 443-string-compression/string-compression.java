class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while(j < n){
            while(j<n && chars[i] == chars[j]){
                j++;
            }
                count = j-i;
                sb.append(chars[i]);
                if(count > 1) sb.append(count);
                i = j;
        
        }
       
        for(int k = 0; k < sb.length() ; k++){
            chars[k] = sb.charAt(k);
        }
        return sb.length();
    }
}