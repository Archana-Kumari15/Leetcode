class Solution {
    public void dfs(TreeNode root, int depth, List<Integer> res){
        if(root == null) return;
        if(res.size() == depth){
            res.add(root.val);
        }else{
            res.set(depth,Math.max(res.get(depth),root.val));
        }
        
        dfs(root.left,depth+1,res);
        dfs(root.right,depth+1,res);
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root,0,res);
        return res;
    }
}