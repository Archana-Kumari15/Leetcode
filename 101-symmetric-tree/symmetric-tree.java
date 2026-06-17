class Solution {
    public boolean solve(TreeNode l, TreeNode r){
        if(l == null && r == null) return true;
        if(l == null) return false;
        if(r == null) return false;
        if(l.val != r.val){
            return false;
        }
        return solve(l.left,r.right) && solve(l.right,r.left);
    } 
    public boolean isSymmetric(TreeNode root) {
        return solve(root.left,root.right);
    }
}