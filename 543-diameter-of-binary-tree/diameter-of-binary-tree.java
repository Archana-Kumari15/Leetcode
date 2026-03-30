class Solution {
    public int level(TreeNode root,Map<TreeNode,Integer> dp){
        if(root == null) return 0;
        return 1 + Math.max(level(root.left,dp),level(root.right,dp));
    }
    public int diameter(TreeNode root,Map<TreeNode,Integer> dp) {
        if(root == null) return 0;
        int myDia = level(root.left,dp) + level(root.right,dp);
        int left = diameter(root.left,dp);
        int right = diameter(root.right,dp);
        return Math.max(myDia,Math.max(left,right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode,Integer> dp = new HashMap<>();
        return diameter(root,dp);
    }
}