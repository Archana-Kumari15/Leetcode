class Solution {
    static int maxdiff;
    public void findMax(TreeNode root, TreeNode child){
        if(root == null || child == null) return;
        maxdiff = Math.max(maxdiff,Math.abs(root.val - child.val));
        findMax(root,child.left);
        findMax(root,child.right);
    }
    public void findMaxDiff(TreeNode root){
        if(root == null) return;
        findMax(root,root.left);
        findMax(root,root.right);
        findMaxDiff(root.left);
        findMaxDiff(root.right);
    }
    public int maxAncestorDiff(TreeNode root) {
        maxdiff = -1;
        findMaxDiff(root);
        return maxdiff;
    }
}