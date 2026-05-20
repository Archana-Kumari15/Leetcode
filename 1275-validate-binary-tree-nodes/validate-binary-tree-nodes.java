class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        Arrays.fill(parent,-1);
        for(int i = 0; i<n ; i++){
            int left = leftChild[i];
            int right= rightChild[i];

            if(left != -1){
                if(parent[left] != -1){
                    return false;
                }
                parent[left] = i;
            }
            if(right != -1){
                if(parent[right] != -1){
                    return false;
                }
                parent[right] = i;
            }
        }
        int root = -1;
        for(int i = 0; i<n ; i++){
            if(parent[i] == -1){
                if(root != -1)
                   return false;
                root = i;
            }
        }
        if(root == -1) return false;
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(root);
        visited[root] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            int left = leftChild[node];
            int right = rightChild[node];
            if(left != -1){
                if(visited[left]) return false;
                visited[left] = true;
                q.add(left);
            }
            if(right != -1){
                if(visited[right]) return false;
                visited[right] = true;
                q.add(right);
            }
        }
        return count == n;
    }
}
