class Solution {
    class Pair {
        TreeNode node;
        String str;

        Pair(TreeNode node, String str) {
            this.node = node;
            this.str = str;
        }
    }
    public String smallestFromLeaf(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,String.valueOf((char)(root.val + 'a'))));
        String res = "";
        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.node;
            String curr = p.str;
            if(node.left == null && node.right == null){
                if(res.equals("") || curr.compareTo(res)<0){
                    res = curr;
                }
            }
            if(node.left != null){
                q.offer(new Pair(node.left,(char)(node.left.val + 'a') + curr));
            }
           if(node.right != null){
                q.offer(new Pair(node.right,(char)(node.right.val + 'a') + curr));
            }
        }
        return res;
    }
}