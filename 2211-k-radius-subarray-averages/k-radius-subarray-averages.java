import java.util.Arrays;
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        if(k==0) return nums;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        if(n < 2*k+1){
           return  result;
        }
        long  window = 0;
        int left = 0;
        int right = 2*k;
        int i = k;

        for(int j = left; j <= right; j++){
             window += nums[j];
        }
        int count = 2*k+1;
        result[i] = (int)(window / count);

        i++;
        right++;
        while(right < n){
            int out = nums[left];
            int come = nums[right];
            window = window + come - out;
            result[i] = (int)(window / count);

            i++;
            right++;
            left++;
        }
        return result;
    }
}