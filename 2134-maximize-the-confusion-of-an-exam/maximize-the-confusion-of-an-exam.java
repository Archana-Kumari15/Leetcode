class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        StringBuilder sb = new StringBuilder(answerKey);
        int n = sb.length();
        int i = 0, j = 0;
        int res = 0;
        int countF = 0;
        while(j < n){
            if(sb.charAt(j) == 'F')
            countF++;
            while(countF > k){
                if(sb.charAt(i) == 'F'){
                    countF--;
                }
                i++;
            }
            res = Math.max(res,j-i+1);
            j++;
        }
        i = 0; j = 0;
        int countT = 0;
        while(j < n){
            if(sb.charAt(j) == 'T')
            countT++;
            while(countT > k){
                if(sb.charAt(i) == 'T'){
                    countT--;
                }
                i++;
            }
            res = Math.max(res,j-i+1);
            j++;
        }
        return res;
    }
}