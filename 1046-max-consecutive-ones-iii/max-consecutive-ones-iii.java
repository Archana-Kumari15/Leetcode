class Solution {
    public int longestOnes(int[] arr, int k) {
        int i = 0, maxLen = 0;
        for (int j = 0;j < arr.length;j++) {
            if (arr[j] == 0)  k--; 
            while (k < 0) {
                if (arr[i] == 0) k++;
                i++;
            }
            int len = j - i + 1;
            maxLen = Math.max(maxLen,len);
        }
       return maxLen;
    }
}
