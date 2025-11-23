class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = Integer.MIN_VALUE;
        dp[2] = Integer.MIN_VALUE;

        for (int x : nums) {
            int[] newDp = dp.clone(); 

            for (int r = 0; r < 3; r++) {
                if (dp[r] == Integer.MIN_VALUE) continue;

                int newR = (r + x) % 3;
                newDp[newR] = Math.max(newDp[newR], dp[r] + x);
            }

            dp = newDp;
        }

        return dp[0]; 
    }
}