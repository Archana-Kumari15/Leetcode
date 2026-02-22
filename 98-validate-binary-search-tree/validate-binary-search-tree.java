class Solution {
    // static boolean flag;
    // private long max(TreeNode root){
    //     if(root == null) return Long.MIN_VALUE;
    //     long leftmax = max(root.left);
    //     if(leftmax >= root.val) flag = false;
    //     long rightmax = max(root.right);
    //     return Math.max(root.val,Math.max(leftmax,rightmax));
    // }
    // private long min(TreeNode root){
    //     if(root == null) return Long.MAX_VALUE;
    //     long leftmin = min(root.left);
    //     long rightmin = min(root.right);
    //     if(rightmin <= root.val) flag = false;
    //     return Math.min(root.val,Math.min(leftmin,rightmin));
    // }

    private void inorder(TreeNode root, List<Integer> arr){
        if(root == null) return;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }

    public boolean isValidBST(TreeNode root) {
        // flag = true;
        // max(root);
        // min(root);
        // return flag;

        List<Integer> arr = new ArrayList<>();
        inorder(root,arr);
        for(int i = 1; i<arr.size(); i++){
            if(arr.get(i) <= arr.get(i-1)) return false;
        }
        return true;
    }
}