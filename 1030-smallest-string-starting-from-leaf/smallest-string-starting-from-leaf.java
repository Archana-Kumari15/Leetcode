class Solution {
    String res = "";
    public void dfs(TreeNode root, String curr){
        if(root == null) return;
        curr = (char)(root.val + 'a') + curr;
        if(root.left == null && root.right == null){
            if(res.isEmpty() || curr.compareTo(res) < 0){
                res = curr;
            }
            return;
        }
        dfs(root.left,curr);
        dfs(root.right,curr);
    }
    public String smallestFromLeaf(TreeNode root) {
        dfs(root,"");
        return res;
    }
}