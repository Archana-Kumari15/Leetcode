class Solution {
    public int countnodes(TreeNode root){
        if(root == null) return 0;
        return 1 + countnodes(root.left) + countnodes(root.right);
    }
    public boolean dfs(TreeNode root,int i , int totalnodes){
        if(root == null) return true;
        if(i > totalnodes) return false;
        return dfs(root.left,2*i,totalnodes) && dfs(root.right,2*i+1,totalnodes);
    }
    public boolean isCompleteTree(TreeNode root) {
        int totalnodes = countnodes(root);
        int i = 1;
        return dfs(root,i,totalnodes);
    }
}