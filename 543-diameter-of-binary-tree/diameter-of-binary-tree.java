class Solution {
    public int level(TreeNode root,int[] dia){
        if(root == null) return 0;
        int leftlevel = level(root.left,dia);
        int rightlevel = level(root.right,dia);
        int mydia = leftlevel + rightlevel;
        dia[0] = Math.max(dia[0],mydia);
        return 1 + Math.max(leftlevel,rightlevel);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] dia = {0};
        level(root,dia);
        return dia[0];
    }
}