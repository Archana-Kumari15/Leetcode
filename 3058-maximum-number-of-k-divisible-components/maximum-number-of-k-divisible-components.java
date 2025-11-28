class Solution {
    public int k;
    public List<Integer>[] graph;
    public int components;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k = k;
        this.components = 0;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        dfs(0, -1, values);

        return components;
    }

   public long dfs(int u, int parent, int[] values) {
        long sum = values[u];  

        for (int v : graph[u]) {
            if (v == parent) continue;
            sum += dfs(v, u, values);
        }
        if (sum % k == 0) {
            components++;
            return 0L;
        }
        return sum;
    }
}