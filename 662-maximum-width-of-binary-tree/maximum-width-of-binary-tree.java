class Solution {
    class pair{
        TreeNode node;
        long idx;
        pair(TreeNode node,long idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Deque<pair> q = new ArrayDeque<>();
        q.offer(new pair(root,0));
        long maxWidth = 0;
        while(!q.isEmpty()){
            long left = q.peekFirst().idx;
            long right = q.peekLast().idx;
            maxWidth = Math.max(maxWidth,right-left+1);
            long n = q.size();
            for(int i = 0; i<n ; i++){
                pair curr = q.poll();
                TreeNode node = curr.node;
                long idx = curr.idx-left;
                if(node.left != null)
                   q.offer(new pair(node.left,2*idx + 1));
                if(node.right != null)
                   q.offer(new pair(node.right,2*idx+2));
            }
        }
        return (int)maxWidth;
    }
}