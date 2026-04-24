class Solution {
    public void preorder(TreeNode root, int lvl ,List<Integer> res){
        if(root == null) return;
        while(res.size() < lvl){
            res.add(root.val);
        }
        preorder(root.right,lvl+1,res);
        preorder(root.left,lvl+1,res);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,1,res);
        return res;
    }
}