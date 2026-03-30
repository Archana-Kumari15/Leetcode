class Solution {
    static int maxsum;
    public int linesum(TreeNode root){
        if(root == null) return 0;
        int leftlinesum = linesum(root.left);
        int rightlinesum = linesum(root.right);
        int pathsum = root.val;
        if(leftlinesum > 0) pathsum += leftlinesum;
        if(rightlinesum > 0) pathsum += rightlinesum;
        maxsum = Math.max(pathsum,maxsum);
        return root.val + Math.max(0,Math.max(leftlinesum,rightlinesum));
    }
    public int maxPathSum(TreeNode root) {
        maxsum = Integer.MIN_VALUE;
        linesum(root);
        return maxsum;
    }
}