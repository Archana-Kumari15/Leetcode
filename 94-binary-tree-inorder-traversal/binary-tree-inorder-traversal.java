class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                res.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode leftchild = curr.left;
                while(leftchild.right != null){
                    leftchild = leftchild.right;
                }
                leftchild.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return res;
    }
}