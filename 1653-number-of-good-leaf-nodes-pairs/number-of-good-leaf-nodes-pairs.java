class Solution {
    public void makegraph(TreeNode root, TreeNode prev, Map<TreeNode,List<TreeNode>> adj, Set<TreeNode> st){
        if(root == null) return;
        adj.putIfAbsent(root, new ArrayList<>());
        if(root.left == null && root.right == null){
            st.add(root);
        }
        if(prev != null){
            //adj.putIfAbsent(prev, new ArrayList<>());
            adj.get(root).add(prev);
            adj.get(prev).add(root);
        }
        makegraph(root.left,root,adj,st);
        makegraph(root.right,root,adj,st);
    }
    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode,List<TreeNode>> adj = new HashMap<>();
        Set<TreeNode> st = new HashSet<>();
        makegraph(root,null,adj,st);
        int count = 0;
        for(TreeNode leaf : st){
            Queue<TreeNode> q = new LinkedList<>();
            Set<TreeNode> set = new HashSet<>();
            q.add(leaf);
            set.add(leaf);
            int level = 0;
            while(!q.isEmpty() && level<=distance){
                int n = q.size();
                for(int i = 0; i <n ; i++){
                    TreeNode curr = q.poll();
                    if(curr != leaf && st.contains(curr)){
                        count++;
                    }
                    for(TreeNode neigh : adj.get(curr)){
                        if(!set.contains(neigh)){
                            q.add(neigh);
                            set.add(neigh);
                        }
                    }
                }
                level++;
            }
        }
        return count/2;
    }
}