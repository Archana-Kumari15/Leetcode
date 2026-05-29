class Solution {
    int res;
    public void bfs(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            res = temp.val;
            if(temp.right != null){
                q.add(temp.right);
            }
            if(temp.left != null){
                q.add(temp.left);
            }
        }
    }
    public int findBottomLeftValue(TreeNode root) {
        res = 0;
        bfs(root);
        return res;
    }
}