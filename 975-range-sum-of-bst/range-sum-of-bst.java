class Solution {
    public int inorder(TreeNode root, int low, int high){
        int sum = 0;
        if(root == null) return 0;
        sum += inorder(root.left,low,high);
        if(root.val >= low && root.val <= high){
            sum += root.val;
        }
        sum += inorder(root.right,low,high);
        return sum;
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
      return inorder(root,low,high);
    }
}

