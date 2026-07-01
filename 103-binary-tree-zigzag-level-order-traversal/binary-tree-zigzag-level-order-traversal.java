class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> solve(TreeNode root){
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean reverse = false;
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i<n ; i++){
                TreeNode curr = q.poll();
                level.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(reverse) Collections.reverse(level);
            res.add(level);
            reverse = !reverse;
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        res = new ArrayList<>();
        return solve(root);
    }
}