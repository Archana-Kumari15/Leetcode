class Solution {
    static int result;
    public int[] solve(TreeNode root){
       if(root == null) return new int[]{0,0};
       int[] left = solve(root.left);
       int[] right = solve(root.right);
       int sum = left[0] + right[0] + root.val;
       int count = left[1] + right[1] + 1;
       if(root.val == sum/count){
        result++;
       }
       return new int[]{sum,count};
    }
    public int averageOfSubtree(TreeNode root) {
        result = 0;
        solve(root);
        return result;
    }
}