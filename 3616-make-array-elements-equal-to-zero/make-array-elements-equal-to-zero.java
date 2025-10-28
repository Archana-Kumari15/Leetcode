class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int start = 0; start < n; start++) {
            if (nums[start] != 0) continue;
            for (int dir : new int[]{-1, 1}) {
                int[] arr = nums.clone();
                int curr = start;
                int d = dir;

                while (curr >= 0 && curr < n) {
                    if (arr[curr] == 0) {
                        curr += d;
                    } else {
                        arr[curr]--;
                        d = -d;
                        curr += d;
                    }
                }
                boolean allZero = true;
                for (int val : arr) {
                    if (val != 0) {
                        allZero = false;
                        break;
                    }
                }

                if (allZero) count++;
            }
        }

        return count;
    }
}