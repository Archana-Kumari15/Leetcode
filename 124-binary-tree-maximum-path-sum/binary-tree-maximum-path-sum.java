class Solution {
    static int maxSum;
    public int solve(TreeNode root){
        if(root == null) return 0;
        int l = solve(root.left);
        int r = solve(root.right);
        int niche_hi_mil_gya_ans = l + r + root.val;
        int koi_ek_acha = Math.max(l,r) + root.val;
        int only_root_acha = root.val;
        maxSum = Math.max(maxSum,Math.max(niche_hi_mil_gya_ans,Math.max(koi_ek_acha,only_root_acha)));
        return Math.max(only_root_acha,koi_ek_acha);
    }
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}