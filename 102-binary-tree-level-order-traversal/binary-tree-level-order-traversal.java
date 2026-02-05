class Solution {
    public class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public int levels(TreeNode root){
        if(root == null) return 0;
        return 1+Math.max(levels(root.left), levels(root.right));
    }
    // public void nthLevel(TreeNode root, int level , int lvl, ArrayList<Integer> arr){
    //     if(root == null) return;
    //     if(level > lvl) return;
    //     if(level == lvl) arr.add(root.val);
    //     nthLevel(root.left,level+1,lvl,arr);
    //     nthLevel(root.right,level+1,lvl,arr);
    // }

    public void bfs(TreeNode root, List<List<Integer>> ans){
        Queue<Pair> q = new LinkedList<>();
        if(root != null) q.add(new Pair(root,0));
        while(q.size() > 0){
            Pair front = q.remove();
            TreeNode temp = front.node;
            int lvl = front.level;
            ans.get(lvl).add(temp.val);
            if(temp.left != null) q.add(new Pair(temp.left, lvl+1));
            if(temp.right != null) q.add(new Pair(temp.right, lvl+1));
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int lvl = levels(root);
        for(int i = 0; i<lvl ; i++){
            ArrayList<Integer> arr = new ArrayList<>();
            ans.add(arr);
        }
        bfs(root,ans);
        return ans;
    }
}