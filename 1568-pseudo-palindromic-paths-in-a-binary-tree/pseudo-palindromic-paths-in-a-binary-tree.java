class Solution {
    int res = 0;
    public void solve(TreeNode root,int count){
        if(root == null) return;
        count = (count ^ (1 << root.val));
        if(root.left == null && root.right == null){
           if((count & (count-1)) == 0){
            res++;
           }
        }
        solve(root.left,count);
        solve(root.right,count);
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        int count = 0;
        solve(root,count);
        return res;
    }
}
