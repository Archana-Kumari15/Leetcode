class Solution {
    static int result;
    public int solve(TreeNode root,int start){
        if(root == null) return 0;
        int lh = solve(root.left,start);
        int rh = solve(root.right,start);
        if(start == root.val){
            result = Math.max(lh,rh);
            return -1;
        }
        else if(lh>=0 && rh >= 0){
            return Math.max(lh,rh) + 1;
        }
        else{
            int d = Math.abs(lh) + Math.abs(rh);
            result = Math.max(d,result);
            return Math.min(lh,rh) -  1;
        }
    }
    public int amountOfTime(TreeNode root, int start) {
        result = Integer.MIN_VALUE;
        solve(root,start);
        return result;
    }
}