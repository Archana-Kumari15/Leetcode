class Solution {
    static boolean flag;
    private long max(TreeNode root){
        if(root == null) return Long.MIN_VALUE;
        long leftmax = max(root.left);
        if(leftmax >= root.val) flag = false;
        long rightmax = max(root.right);
        return Math.max(root.val,Math.max(leftmax,rightmax));
    }
    private long min(TreeNode root){
        if(root == null) return Long.MAX_VALUE;
        long leftmin = min(root.left);
        long rightmin = min(root.right);
        if(rightmin <= root.val) flag = false;
        return Math.min(root.val,Math.min(leftmin,rightmin));
    }
    public boolean isValidBST(TreeNode root) {
        flag = true;
        max(root);
        min(root);
        return flag;
    }
}