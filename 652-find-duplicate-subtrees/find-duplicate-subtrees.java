class Solution {
    public String getSubtreeString(TreeNode root,Map<String,Integer> map,List<TreeNode> res){
        if(root == null) return "N";
        String s = root.val + "," + getSubtreeString(root.left,map,res) + "," + getSubtreeString(root.right,map,res);
        if(map.getOrDefault(s,0) == 1){
            res.add(root);
        }
        map.put(s, map.getOrDefault(s,0) + 1);
        return s;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String,Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        getSubtreeString(root,map,res);
        return res;
    }
}