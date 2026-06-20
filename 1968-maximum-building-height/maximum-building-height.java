class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> arr = new ArrayList<>();
        arr.add(new int[]{1, 0});
        for (int[] r : restrictions) {
            arr.add(new int[]{r[0], r[1]});
        }

        arr.sort((a, b) -> a[0] - b[0]);

        if (arr.get(arr.size() - 1)[0] != n) {
            arr.add(new int[]{n, n - 1});
        }
        int m = arr.size();
        for (int i = 1; i < m; i++) {
            int dist = arr.get(i)[0] - arr.get(i - 1)[0];
            arr.get(i)[1] = Math.min(
                arr.get(i)[1],
                arr.get(i - 1)[1] + dist
            );
        }

        for (int i = m - 2; i >= 0; i--) {
            int dist = arr.get(i + 1)[0] - arr.get(i)[0];
            arr.get(i)[1] = Math.min(
                arr.get(i)[1],
                arr.get(i + 1)[1] + dist
            );
        }

        int ans = 0;

        for (int i = 1; i < m; i++) {

            int x1 = arr.get(i - 1)[0];
            int h1 = arr.get(i - 1)[1];

            int x2 = arr.get(i)[0];
            int h2 = arr.get(i)[1];

            int d = x2 - x1;

            int rem = d - Math.abs(h1 - h2);

            int peak = Math.max(h1, h2) + rem / 2;

            ans = Math.max(ans, peak);
        }

        return ans;
    }
}