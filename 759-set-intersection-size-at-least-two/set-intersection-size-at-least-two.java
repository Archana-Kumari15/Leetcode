class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> 
            a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
        );

        int p1 = -1, p2 = -1; 
        int count = 0;

        for (int[] in : intervals) {
            int start = in[0];
            int end = in[1];
            if (p2 >= start) {
                continue;
            }
            if (p1 >= start) {
                count += 1;
                p2 = p1;
                p1 = end;
            } 
            else {
                count += 2;
                p2 = end - 1;
                p1 = end;
            }
        }

        return count;
    }
}