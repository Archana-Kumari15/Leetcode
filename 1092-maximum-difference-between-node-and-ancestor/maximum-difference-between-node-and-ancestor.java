class Solution {
    static int maxdiff;
    public int findMaxDiff(TreeNode root, int minV, int maxV){
        if(root == null){
            return Math.abs(maxV-minV);
        }
        minV = Math.min(minV,root.val);
        maxV = Math.max(maxV,root.val);
        int l = findMaxDiff(root.left,minV,maxV);
        int r = findMaxDiff(root.right,minV,maxV);
        return Math.max(l,r);
    }
    public int maxAncestorDiff(TreeNode root) {
       return  findMaxDiff(root,root.val,root.val);     
    }
}