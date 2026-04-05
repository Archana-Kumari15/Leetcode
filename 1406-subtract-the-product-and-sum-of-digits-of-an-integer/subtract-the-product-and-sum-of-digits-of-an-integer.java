class Solution {
    public int subtractProductAndSum(int n) {
        int rem = 0;
        int mul = 1;
        while(n>0){
        int digit = n % 10;
        rem += digit;
        mul *= digit;
        n /= 10;
        }
        return mul - rem;
    }
}