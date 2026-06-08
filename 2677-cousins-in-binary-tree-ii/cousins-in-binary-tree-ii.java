class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int levelsum = root.val;
        while(!q.isEmpty()){
            int n = q.size();
            int nextlevelsum = 0;
            for(int i = 0; i<n ; i++){
                TreeNode curr = q.poll();
                curr.val = levelsum - curr.val;
            
                int siblingsum = curr.left != null ? curr.left.val : 0;
                siblingsum += curr.right != null ? curr.right.val : 0;
                if(curr.left != null){
                    nextlevelsum += curr.left.val;
                    curr.left.val = siblingsum;
                    q.add(curr.left);
                }
                if(curr.right != null){
                    nextlevelsum += curr.right.val;
                    curr.right.val = siblingsum;
                    q.add(curr.right);
                }
            }
            levelsum = nextlevelsum;
        }
        return root;

    }
}