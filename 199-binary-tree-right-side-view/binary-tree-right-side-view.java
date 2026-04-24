class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            TreeNode node = null;
            while(n>0){
                node = q.peek();
                q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                n--;
            }
            ans.add(node.val);
        }
        return ans;
    }
}