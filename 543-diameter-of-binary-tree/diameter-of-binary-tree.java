class Solution {
    public int levels(TreeNode root, int[] maxDia){
         if(root == null) return 0;
        // return 1 + Math.max(levels(root.left),levels(root.right));
        int leftlevel = levels(root.left,maxDia);
        int rightlevel = levels(root.right,maxDia);
        int dia = leftlevel + rightlevel;
        maxDia[0] = Math.max(dia,maxDia[0]);
        return 1 + Math.max(leftlevel,rightlevel);

    }
    public int diameterOfBinaryTree(TreeNode root) {
        // if(root == null) return 0;
        // int myDia = levels(root.left) + levels(root.right);
        // int leftDia = diameterOfBinaryTree(root.left);
        // int rightDia = diameterOfBinaryTree(root.right);
        // return Math.max(myDia, Math.max(leftDia,rightDia));

        int[] maxDia = {0};
        levels(root,maxDia);
        return maxDia[0];
    }
}