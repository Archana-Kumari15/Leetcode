class Solution {
    public boolean inorder(TreeNode root,int sum, int target){
        if(root == null) return false;
        sum += root.val;
        if(root.left == null && root.right == null){
            if(sum == target) return true;
            return false;
        }
        boolean left = inorder(root.left,sum,target);
        boolean right = inorder(root.right,sum,target);
        return left || right;
    }
    public boolean hasPathSum(TreeNode root, int target) {
        int sum = 0;
        boolean result = inorder(root,sum,target);
        return result;
    }
}