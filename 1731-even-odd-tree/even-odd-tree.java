class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); 
        boolean evenlevel = true;
        while(!q.isEmpty()){
            int n = q.size();
            int prev;
            if(evenlevel) prev = Integer.MIN_VALUE;
            else prev = Integer.MAX_VALUE;
            for(int i = 0; i<n ; i++){
                TreeNode curr = q.poll();
                if(evenlevel && (curr.val % 2 == 0 || curr.val <= prev)){
                    return false;
                }
                if(!evenlevel && (curr.val % 2 != 0 || curr.val >= prev)){
                    return false;
                }
                prev = curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            evenlevel = !evenlevel;
        }
        return true;
    }
}