class Solution {
    public int totalMoney(int n) {
         int weeks = n / 7;
        int days = n % 7;
        int fullWeeksSum = 7 * (weeks * (weeks - 1) / 2) + 28 * weeks;
        int remainderSum = days * (weeks + 1) + (days * (days - 1) / 2);

        return fullWeeksSum + remainderSum;
    }
}