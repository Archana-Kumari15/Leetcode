class Solution {
    public TreeNode delete(TreeNode root, Set<Integer> st, List<TreeNode> result){
        if(root == null) return null;
        root.left = delete(root.left,st,result);
        root.right = delete(root.right,st,result);
        if(st.contains(root.val)){
            if(root.left != null) result.add(root.left);
            if(root.right != null) result.add(root.right);
            return null;
        }
        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> st = new HashSet<>();
        List<TreeNode> result = new ArrayList<>();

        for(int num : to_delete){
            st.add(num);
        }
        root = delete(root,st,result);
        if(root != null){
            result.add(root);
        }
        return result;
    }
}