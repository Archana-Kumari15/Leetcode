class Solution {
    static HashMap<TreeNode,TreeNode> parent;
    public void inorder(TreeNode root){
        if(root == null) return;
        if(root.left != null){
            parent.put(root.left, root);
            inorder(root.left);
        }
        if(root.right != null){
            parent.put(root.right, root);
            inorder(root.right);
        }
    }
    public void bfs(TreeNode target, int k, List<Integer> result){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        Set<TreeNode> set = new HashSet<>();
        set.add(target);
        while(!q.isEmpty()){
            int n = q.size();
            if(k == 0) break;
            for(int i = 0; i<n ; i++){
                TreeNode curr = q.poll();
                if(curr.left != null && !set.contains(curr.left)){
                    q.add(curr.left);
                    set.add(curr.left);
                }
                if(curr.right != null && !set.contains(curr.right)){
                    q.add(curr.right);
                    set.add(curr.right);
                }
                if (parent.containsKey(curr) &&
                    !set.contains(parent.get(curr))) {

                    q.add(parent.get(curr));
                    set.add(parent.get(curr));
                }
            }
            k--;
        }
         while (!q.isEmpty()) {
            result.add(q.poll().val);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        inorder(root);
        bfs(target,k,result);
        return result;
    }
}