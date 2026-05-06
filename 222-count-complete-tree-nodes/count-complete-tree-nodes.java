class Solution {
    public int getleftnode(TreeNode root){
        TreeNode temp = root;
        int lh = 0;
        while(temp != null){
            temp = temp.left;
            lh++;
        }
        return lh;
    }
    public int getrightnode(TreeNode root){
        TreeNode temp = root;
        int rh = 0;
        while(temp != null){
            temp = temp.right;
            rh++;
        }
        return rh;
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh = getleftnode(root);
        int rh = getrightnode(root);
        if(lh == rh){
            return (int)(Math.pow(2,lh))-1;
        }
        return countNodes(root.left) + 1 + countNodes(root.right);
        }
}