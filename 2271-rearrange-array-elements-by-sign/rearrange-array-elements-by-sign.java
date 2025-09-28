class Solution { 
    public int[] rearrangeArray(int[] nums) {
              int n = nums.length;
        int[] result = new int[n];

        int[] pos = new int[n/2];
        int[] neg = new int[n/2];
        int p = 0, q = 0;
        for (int num : nums) {
            if (num > 0) pos[p++] = num;
            else neg[q++] = num;
        }

        p = 0; q = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) result[i] = pos[p++]; 
            else result[i] = neg[q++];           
        }
        return result;
    }
}

