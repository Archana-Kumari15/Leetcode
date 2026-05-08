class Solution {
    static long SUM;
    static long maxP;
    public int totalsum(TreeNode root){
        if(root == null) return 0;
        int leftsubtree = totalsum(root.left);
        int rightsubtree = totalsum(root.right);
        long subtree = root.val + leftsubtree + rightsubtree;
        long remaining = SUM - subtree;
        maxP = Math.max(maxP, subtree*remaining);
        return (int)subtree;
    }
    
    public int maxProduct(TreeNode root) {
        if(root == null) return 0;
        maxP = 0;
        SUM = 0;
        SUM = totalsum(root);
        maxP = 0;
        totalsum(root);
        return (int)(maxP % 1000000007);
    }
}