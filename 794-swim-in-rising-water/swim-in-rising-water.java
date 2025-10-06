class Solution {
    public int swimInWater(int[][] grid) {
           int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        int res = 0;
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int height = curr[0];
            int r = curr[1];
            int c = curr[2];
            
            res = Math.max(res, height);
            if (r == n - 1 && c == n - 1) return res;
            
            if (visited[r][c]) continue;
            visited[r][c] = true;
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    pq.offer(new int[]{grid[nr][nc], nr, nc});
                }
            }
        }
        return res;
    }
}