class Solution {
    public int sum(TreeNode root, int curr){
        if(root == null) return 0;
        curr = curr*10 + root.val;
        if(root.left == null && root.right == null) return curr;
        int l = sum(root.left,curr);
        int r = sum(root.right,curr);
        return l + r;
    }
    public int sumNumbers(TreeNode root) {
        return sum(root,0);
    }
}