class Solution {
    public int levels(TreeNode root){
        if(root == null) return 0;
        return 1+Math.max(levels(root.left), levels(root.right));
    }
    public void nthLevel(TreeNode root, int level , int lvl, ArrayList<Integer> arr){
        if(root == null) return;
        if(level > lvl) return;
        if(level == lvl) arr.add(root.val);
        nthLevel(root.left,level+1,lvl,arr);
        nthLevel(root.right,level+1,lvl,arr);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int lvl = levels(root);
        for(int i = 0; i<lvl ; i++){
            ArrayList<Integer> arr = new ArrayList<>();
            nthLevel(root,0,i,arr);
            ans.add(arr);
        }
        return ans;
    }
}