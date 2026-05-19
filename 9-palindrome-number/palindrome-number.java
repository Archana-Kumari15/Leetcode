class Solution {
   public  boolean isPalindrome(int x) {
        int real=x;
        if(x < 0) return false;
         int ans=0;
         while(x > 0) {
             ans = ans * 10 + x % 10;
             x /= 10;
         }

             return ans == real;
       }

    }
