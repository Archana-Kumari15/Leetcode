class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> levelsum = new ArrayList<>();
        while(!q.isEmpty()){
            int n = q.size();
            int currlevelsum = 0;
            for(int i = 0; i<n ; i++){
                TreeNode curr = q.poll();
                currlevelsum += curr.val;
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            levelsum.add(currlevelsum);
        }
        q.add(root);
        root.val = 0;
        int level = 1;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i<n ; i++){
                TreeNode curr = q.poll();
                int siblingsum = curr.left != null ? curr.left.val : 0;
                siblingsum += curr.right != null ? curr.right.val : 0;
                if(curr.left != null){
                    curr.left.val = levelsum.get(level) - siblingsum;
                    q.add(curr.left);
                }
                if(curr.right != null){
                    curr.right.val = levelsum.get(level) - siblingsum;
                    q.add(curr.right);
                }
            }
            level++;
        }
        return root;

    }
}