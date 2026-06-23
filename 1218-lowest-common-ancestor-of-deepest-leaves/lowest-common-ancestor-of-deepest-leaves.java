class Solution {
    class pair{
        int depth;
        TreeNode node;
        pair(int depth,TreeNode node){
            this.depth = depth;
            this.node = node;
        }
    }
   
    public pair solve(TreeNode root){
        if(root == null){
            return new pair(0,null);
        }

        pair left = solve(root.left);
        pair right = solve(root.right);

        if(left.depth == right.depth){
            return new pair(left.depth+1,root);
        }else if(left.depth > right.depth){
            return new pair(left.depth+1,left.node);
        }else{
            return new pair(right.depth+1,right.node);
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return solve(root).node;
    }
}