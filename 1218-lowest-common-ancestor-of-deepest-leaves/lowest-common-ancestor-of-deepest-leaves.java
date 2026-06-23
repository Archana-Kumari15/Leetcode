class Solution {
    int maxd = 0;
    Map<Integer,Integer> map;
    public void depth(TreeNode root, int d){
        if(root == null) return;
        maxd = Math.max(maxd,d);
        map.put(root.val,d);
        depth(root.left,d+1);
        depth(root.right,d+1);
    }

    public TreeNode lca(TreeNode root){
        if(root == null || map.get(root.val) == maxd){
            return root;
        }
        TreeNode l = lca(root.left);
        TreeNode r = lca(root.right);

        if(l != null && r != null) return root;

        return l != null ? l : r;
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        map = new HashMap<>();
        depth(root,0);
        return lca(root);
    }
}