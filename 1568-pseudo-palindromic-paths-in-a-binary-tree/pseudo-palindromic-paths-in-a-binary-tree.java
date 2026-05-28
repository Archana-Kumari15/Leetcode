class Solution {
    int res = 0;
    public void solve(TreeNode root,int[] count){
        if(root == null) return;
        count[root.val]++;
        if(root.left == null && root.right == null){
            int oddfreq = 0;
            for(int i = 0; i<=9 ; i++){
                if(count[i] % 2 != 0){
                    oddfreq++;
                }
            }
            if(oddfreq <= 1){
                res++;
            }
        }
        solve(root.left,count);
        solve(root.right,count);
        count[root.val]--;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] count = new int[10];
        solve(root,count);
        return res;
    }
}
