class Solution {
    static int maxPath = 0;
    public void solve(TreeNode root, int steps , boolean goleft){
        if(root == null) return;
        maxPath = Math.max(maxPath,steps);
        if(goleft == true){
            solve(root.left,steps+1,false);
            solve(root.right,1,true);
        }else{
            solve(root.right,steps+1,true);
            solve(root.left,1,false);
        }
    }
    public int longestZigZag(TreeNode root) {
        maxPath = 0;
        solve(root,0,true);
        solve(root,0,false);
        return maxPath;
    }
}