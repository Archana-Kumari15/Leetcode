class Solution {
   public  boolean isPalindrome(int x) {
        // int real=x;
        // if(x < 0) return false;
        //  int ans=0;
        //  while(x > 0) {
        //      ans = ans * 10 + x % 10;
        //      x /= 10;
        //  }

        //      return ans == real;

        String s = Integer.toString(x);
        int i = 0 , j = s.length()-1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
             i++;
             j--;
        }
        return true; 
       }

    }
