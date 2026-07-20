class Solution {
    int maxD = 0;
    Map<Integer,Integer> map = new HashMap<>();
    public void depth(TreeNode root, int d){
        if(root == null) return;
        maxD = Math.max(maxD,d);
        map.put(root.val,d);
        depth(root.left,d+1);
        depth(root.right,d+1);
    }
    public TreeNode lca(TreeNode root){
        if(root == null || map.get(root.val) == maxD){
            return root;
        }
        TreeNode left = lca(root.left);
        TreeNode right = lca(root.right);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth(root,0);
        return lca(root);
    }
}