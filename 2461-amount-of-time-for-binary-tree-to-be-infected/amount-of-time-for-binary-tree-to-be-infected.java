class Solution {
    public void makegraph(Map<Integer,List<Integer>> adj,int parent,TreeNode curr){
        if(curr == null) return;
        adj.putIfAbsent(curr.val, new ArrayList<>());
        if (parent != -1) {
            adj.get(curr.val).add(parent);

            adj.putIfAbsent(parent, new ArrayList<>());
            adj.get(parent).add(curr.val);
        }
        makegraph(adj,curr.val,curr.left);
        makegraph(adj,curr.val,curr.right);
    } 
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        makegraph(adj,-1,root);
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        int minute = -1;
        while(!q.isEmpty()){
           int n = q.size();
           for(int i = 0; i <n ; i++){
            int curr = q.poll();
            for(int neigh : adj.get(curr)){
                if (!visited.contains(neigh)) {
                    q.add(neigh);
                    visited.add(neigh);
                }
            }
           }
           minute++;
        }
        return minute;
    }
}