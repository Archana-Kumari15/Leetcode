class Solution {
    int maxdepth = -1;
    int bottomleft;
    public void dfs(TreeNode root, int depth){
        if(root == null) return;
        if(depth > maxdepth){
            maxdepth = depth;
            bottomleft = root.val;
        }
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
    public int findBottomLeftValue(TreeNode root) {
        bottomleft = root.val;
        dfs(root,0);
        return bottomleft;
    }
}