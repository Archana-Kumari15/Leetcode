class Solution {
    public class Int{
        int val;
        Int(int val){
            this.val = val;
        }
    }
    public int level(TreeNode root,Int dia){
        if(root == null) return 0;
        int leftlevel = level(root.left,dia);
        int rightlevel = level(root.right,dia);
        int mydia = leftlevel + rightlevel;
        dia.val = Math.max(dia.val,mydia);
        return 1 + Math.max(leftlevel,rightlevel);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Int dia = new Int(0);
        level(root,dia);
        return dia.val;
    }
}